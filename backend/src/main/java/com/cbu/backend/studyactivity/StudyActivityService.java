package com.cbu.backend.studyactivity;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;
import com.cbu.backend.studygroup.StudyGroup;
import com.cbu.backend.studygroup.StudyGroupService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyActivityService {

    private final StudyActivityRepository studyActivityRepository;
    private final MemberService memberService;
    private final StudyActivityMapper studyActivityMapper;
    private final StudyGroupService studyGroupService;

    public Long saveStudyActivity(StudyActivityRequest studyActivityRequest) {
        checkValidRequest(studyActivityRequest);
        List<Member> members =
                studyActivityRequest.getActivityMembers().stream()
                        .map(memberService::getEntity)
                        .toList();
        return studyActivityRepository
                .save(studyActivityMapper.toEntity(studyActivityRequest, members))
                .getId();
    }

    public void updateStudyActivity(Long id, StudyActivityRequest request) {
        checkValidRequest(request);
        List<Member> members =
                request.getActivityMembers().stream().map(memberService::getEntity).toList();
        StudyGroup studyGroup = studyGroupService.getEntity(request.getStudyGroupId());

        getEntity(id)
                .update(
                        request.getTitle(),
                        request.getDescription(),
                        request.getAssignment(),
                        request.getWeek(),
                        request.getPlace(),
                        members,
                        studyGroup,
                        request.getStudyTime());
    }

    public void deleteStudyActivity(Long id) {
        getEntity(id).delete();
    }

    public StudyActivityResponse findStudyActivity(Long id) {
        return studyActivityMapper.toResponse(getEntity(id));
    }

    public List<StudyActivityResponse> findStudyActivityListByStudyGroupId(Long studyGroupId) {
        return studyActivityRepository.findAllByStudyGroupId(studyGroupId).stream()
                .map(studyActivityMapper::toResponse)
                .toList();
    }

    private void checkValidRequest(StudyActivityRequest request) {
        checkStudyTime(request);
        checkParticipantDuplicated(request.getActivityMembers());
    }

    private void checkStudyTime(StudyActivityRequest studyActivityRequest) {
        studyActivityRequest.getStudyTime().isValidStudyTime();
    }

    private void checkParticipantDuplicated(List<UUID> activityMembers) {
        if (activityMembers.size() != getRequestCount(activityMembers)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<UUID> studyGroupParticipants) {
        return studyGroupParticipants.stream().distinct().count();
    }

    private StudyActivity getEntity(Long id) {
        return studyActivityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
