package com.cbu.backend.studygroup;

import com.cbu.backend.global.IdResponse;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;
    private final StudyGroupMapper studyGroupMapper;
    private final MemberService memberService;
    private final AuthService authService;

    public IdResponse<Long> saveStudyGroup(StudyGroupRequest studyGroupRequest) {
        Set<Member> studyMembers =
                studyGroupRequest.getMembers().stream()
                        .map(memberService::getEntity)
                        .collect(Collectors.toSet());
        Member leader = memberService.getEntity(studyGroupRequest.getLeader());

        Long id =
                studyGroupRepository
                        .save(studyGroupMapper.toEntity(studyGroupRequest, leader, studyMembers))
                        .getId();

        return new IdResponse<>(id);
    }

    @Transactional
    public void updateStudyGroup(Long id, StudyGroupRequest studyGroupRequest) {
        StudyGroup studyGroup = getEntity(id);
        Set<Member> studyMembers =
                studyGroupRequest.getMembers().stream()
                        .map(memberService::getEntity)
                        .collect(Collectors.toSet());
        Member leader = memberService.getEntity(studyGroupRequest.getLeader());

        studyGroup.updateStudyGroup(
                studyGroupRequest.getName(),
                studyGroupRequest.getDescription(),
                leader,
                studyMembers);
    }

    @Transactional
    public void addLike(Long id) {
        StudyGroup studyGroup = getEntity(id);
        LikeMember likeMember = new LikeMember(authService.getLoginUser(), studyGroup);
        likeMember.addLike();
    }

    @Transactional
    public void cancelLike(Long id) {
        LikeMember likeMember =
                studyGroupRepository
                        .findLikeCountByIdAndMember(id, authService.getLoginUser())
                        .orElseThrow(EntityNotFoundException::new);
        likeMember.cancelLike();
    }

    @Transactional
    public void finishStudy(Long id) {
        getEntity(id).finishStudy();
    }

    @Transactional
    public void deleteStudyGroup(Long id) {
        getEntity(id).deleteStudy();
    }

    public StudyGroupResponse findResponseById(Long id) {
        return studyGroupMapper.toResponse(getEntity(id));
    }

    public List<StudyGroupResponse> findAllStudyGroup(Pageable pageable) {
        return studyGroupRepository.findAll(pageable).stream()
                .map(studyGroupMapper::toResponse)
                .toList();
    }

    public StudyGroup getEntity(Long id) {
        return studyGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
