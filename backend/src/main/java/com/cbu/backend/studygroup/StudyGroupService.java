package com.cbu.backend.studygroup;

import com.cbu.backend.member.MemberService;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;

import com.cbu.backend.util.AuthUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;
    private final StudyGroupMapper studyGroupMapper;
    private final MemberService memberService;

    public Long saveStudyGroup(StudyGroupRequest studyGroupRequest) {
        checkParticipantDuplicated(studyGroupRequest.getMembers());
        List<Member> studyMembers =
                studyGroupRequest.getMembers().stream().map(memberService::findById).toList();
        Member leader = memberService.findById(studyGroupRequest.getLeader());

        return studyGroupRepository
                .save(studyGroupMapper.toEntity(studyGroupRequest, leader, studyMembers))
                .getId();
    }

    @Transactional
    public void updateStudyGroup(Long id, StudyGroupRequest studyGroupRequest) {
        checkParticipantDuplicated(studyGroupRequest.getMembers());
        StudyGroup studyGroup = getEntity(id);
        List<Member> studyMembers =
                studyGroupRequest.getMembers().stream().map(memberService::findById).toList();
        Member leader = memberService.findById(studyGroupRequest.getLeader());

        studyGroup.updateStudyGroup(
                studyGroupRequest.getName(),
                studyGroupRequest.getDescription(),
                leader,
                studyMembers);
    }

    @Transactional
    public void addLike(Long id) {
        StudyGroup studyGroup = getEntity(id);
        LikeMember likeMember = new LikeMember(AuthUtils.getLoginUser(), studyGroup);
        likeMember.addLike();
    }

    @Transactional
    public void cancelLike(Long id) {
        LikeMember likeMember =
                studyGroupRepository
                        .findLikeCountByIdAndMember(id, AuthUtils.getLoginUser())
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

    private void checkParticipantDuplicated(List<UUID> studyGroupParticipants) {
        if (studyGroupParticipants.size() != getRequestCount(studyGroupParticipants)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<UUID> studyGroupParticipants) {
        return studyGroupParticipants.stream().distinct().count();
    }

    private StudyGroup getEntity(Long id) {
        return studyGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
