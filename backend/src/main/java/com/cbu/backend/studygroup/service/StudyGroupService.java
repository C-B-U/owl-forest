package com.cbu.backend.studygroup.service;

import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studygroup.mapper.StudyGroupMapper;
import com.cbu.backend.studygroup.repository.StudyGroupRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

/**
 * 스터디 그룹 API의 서비스 로직을 담당하는 클래스
 *
 * @author ohksj(김승진)
 */
@Service
@RequiredArgsConstructor
public class StudyGroupService {

  private final StudyGroupRepository studyGroupRepository;
  private final StudyGroupMapper studyGroupMapper;
  private final StudyActivityLogService studyActivityLogService;
  private final MemberService memberService;

  public StudyGroupResponse createStudyGroup(StudyGroupRequest studyGroupRequest) { // 스터디 등록
    Member leader = memberService.getEntity(studyGroupRequest.getStudyGroupLeader());
    List<Member> members =
        studyGroupRequest.getStudyGroupMembers().stream()
            .map(memberService::getEntity)
            .collect(Collectors.toList());
    StudyGroup studyGroup = studyGroupMapper.toEntity(studyGroupRequest);
    studyGroup.organizeMembers(leader, members);
    studyGroupRepository.save(studyGroup);

        return studyGroupMapper.toResponse(studyGroup);
    }

  public StudyGroupResponse findById(Long id) { // 스터디 ID로 조회
    return studyGroupMapper.toResponse(getEntity(id));
  }

    @Transactional
    public void updateLikeCount(
            Long studyGroupId, Integer likeCount) { // 스터디 좋아요 업데이트(Integer like는 -1 or +1)
        studyGroupRepository
                .findById(studyGroupId)
                .ifPresent(studyGroup -> studyGroup.updateLike(likeCount));
    }

  public List<StudyGroupResponse> findStudyGroupSortByCreatedAt(
      Comparator<Comparable> sortDirection) { // 스터디 일지 최신순 조회
    return sort(studyActivityLogService::searchLatestStudyActivityLogCreatedAt, sortDirection);
  }

  public List<StudyGroupResponse> findStudyGroupSortByStudyActivityLog(
      Comparator<Comparable> sortDirection) { // 스터디 일지 개수순 조회
    return sort(studyGroup -> studyGroup.getStudyActivityLogs().size(), sortDirection);
  }

  public List<StudyGroupResponse> findStudyGroupSortByLikeCount(
      Comparator<Comparable> sortDirection) { // 스터디 좋아요순(많은 순서) 조회
    return sort(StudyGroup::getLikeCount, sortDirection);
  }

  /**
   * 세가지 기준으로 정렬해 스터디 그룹을 찾는 서비스들의 공통 로직 빼낸 메서드
   *
   * @param function
   * @param sortDirection
   * @return List<StudyGroupResponse>
   */
  private List<StudyGroupResponse> sort(
      Function<StudyGroup, Comparable> function, Comparator<Comparable> sortDirection) {
    return studyGroupRepository.findAll().stream()
        .sorted(
            Comparator.comparing(function, sortDirection)
                .thenComparing(StudyGroup::getSeason, Comparator.reverseOrder()))
        .map(studyGroupMapper::toResponse)
        .toList();
  }

  @Transactional
  public StudyGroupResponse updateStudyGroup(
      Long studyGroupId, StudyGroupRequest studyGroupRequest) { // 스터디 수정
    StudyGroup studyGroup = getEntity(studyGroupId);
    StudyGroup updatedStudyGroup = studyGroup.update(studyGroupRequest);

    return studyGroupMapper.toResponse(updatedStudyGroup);
  }

  @Transactional
  public void finishStudyGroup(Long id) { // 스터디 마감
    StudyGroup studyGroup = getEntity(id);
    if (studyGroup.getIsActive()) {
      studyGroup.updateIsActive();
    }
  }

  @Transactional
  public StudyGroupResponse deleteStudyGroup(Long id) { // 스터디 삭제
    StudyGroup studyGroup = getEntity(id);
    studyGroup.getBaseTime().delete();

    return studyGroupMapper.toResponse(studyGroup);
  }

  public StudyGroup getEntity(Long id) {
    return studyGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
