package com.cbu.backend.studyactivity;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;

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

    public Long saveStudyActivity(StudyActivityRequest studyActivityRequest) {
        checkValidRequest(studyActivityRequest);
        List<Member> members =
                studyActivityRequest.getStudyParticipants().stream()
                        .map(memberService::getEntity)
                        .toList();
        return studyActivityRepository
                .save(studyActivityMapper.toEntity(studyActivityRequest, members))
                .getId();
    }

    public void updateStudyActivity(Long id, StudyActivityRequest request) {
        checkValidRequest(request);
        List<Member> members =
                request.getStudyParticipants().stream().map(memberService::getEntity).toList();

        getEntity(id)
                .updateStudyActivity(
                        request.getTitle(),
                        request.getDescription(),
                        request.getAssignment(),
                        request.getWeek(),
                        request.getPlace(),
                        members,
                        request.getStudyTime());
    }

    public void deleteStudyActivity(Long id) {
        getEntity(id).deleteStudyActivity();
    }

    public StudyActivityResponse getStudyActivity(Long id) {
        return studyActivityMapper.toResponse(getEntity(id));
    }

    public List<StudyActivityResponse> getStudyActivityListByStudyGroup(Long studyGroupId) {
        return studyActivityRepository.findAllByStudyGroupId(studyGroupId).stream()
                .map(studyActivityMapper::toResponse)
                .toList();
    }

    private void checkValidRequest(StudyActivityRequest request) {
        checkStudyTime(request);
        checkParticipantDuplicated(request.getStudyParticipants());
    }

    private void checkStudyTime(StudyActivityRequest studyActivityRequest) {
        studyActivityRequest.getStudyTime().isValidStudyTime();
    }

    private void checkParticipantDuplicated(List<UUID> studyParticipants) {
        if (studyParticipants.size() != getRequestCount(studyParticipants)) {
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
