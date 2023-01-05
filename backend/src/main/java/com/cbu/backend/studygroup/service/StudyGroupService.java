package com.cbu.backend.studygroup.service;

import com.cbu.backend.studygroup.dto.request.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponse;
import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studygroup.mapper.StudyGroupMapper;
import com.cbu.backend.studygroup.repository.StudyGroupRepository;
import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;
    private final StudyGroupMapper studyGroupMapper;
    private final StudyActivityLogService studyActivityLogService;

    public StudyGroupResponse registerStudyGroup(StudyGroupRequest studyGroupRequest) { // 스터디 등록
        StudyGroup studyGroup = studyGroupMapper.mapToEntity(studyGroupRequest);
        studyGroupRepository.save(studyGroup);

        return studyGroupMapper.toResponse(studyGroup);
    }

    public StudyGroupResponse searchById(Long studyGroupId) { // 스터디 ID로 조회
        StudyGroup studyGroup = studyGroupRepository.findById(studyGroupId)
                .orElseThrow(EntityNotFoundException::new);

        return studyGroupMapper.toResponse(studyGroup);
    }

    @Transactional
    public void updateLikeCount(Long studyGroupId, Integer likeCount) { // 스터디 좋아요 업데이트(Integer like는 -1 or +1)
        studyGroupRepository
                .findById(studyGroupId)
                .ifPresent(studyGroup -> studyGroup.updateLike(likeCount));
    }

    public List<StudyGroupResponse> searchStudyOrderByCreatedAt(Comparator<Comparable> sortDirection) { // 스터디 일지 최신순 조회
        return sort(studyActivityLogService::searchLatestStudyActivityLogCreatedAt, sortDirection);
    }

    public List<StudyGroupResponse> searchStudyOrderByStudyActivityLog(Comparator<Comparable> sortDirection) { // 스터디 일지 개수순 조회
        return sort(studyGroup -> studyGroup.getStudyActivityLogs().size(), sortDirection);
    }

    public List<StudyGroupResponse> searchStudyOrderByLikeCount(Comparator<Comparable> sortDirection) { // 스터디 좋아요순(많은 순서) 조회
        return sort(StudyGroup::getLikeCount, sortDirection);
    }

    private List<StudyGroupResponse> sort(Function<StudyGroup, Comparable> function, Comparator<Comparable> sortDirection) {
        return studyGroupRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(function, sortDirection)
                        .thenComparing(StudyGroup::getSeason, Comparator.reverseOrder()))
                .map(studyGroupMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateStudyGroup(Long studyGroupId, StudyGroupRequest studyGroupRequest) { // 스터디 수정
        Optional<StudyGroup> oStudyGroup = studyGroupRepository.findById(studyGroupId);
        if (!oStudyGroup.isPresent()) {
            throw new RuntimeException();
        }
        StudyGroup studyGroup = oStudyGroup.get();
        StudyGroup updatedStudyGroup = studyGroupMapper.mapToEntity(studyGroupRequest);
        studyGroup.update(updatedStudyGroup);
    }

    @Transactional
    public void closeStudyGroup(Long studyGroupId) {
        StudyGroup studyGroup = studyGroupRepository.findById(studyGroupId).orElseThrow(RuntimeException::new);
        studyGroup.updateIsActive();
    }
}
