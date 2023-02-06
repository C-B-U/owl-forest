package com.cbu.backend.studyactivity.command.service;

import com.cbu.backend.studyactivity.command.domain.StudyActivity;
import com.cbu.backend.studyactivity.command.domain.StudyActivityNo;
import com.cbu.backend.studyactivity.command.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.command.infra.StudyActivityRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyActivityService {

    private final StudyActivityRepository studyActivityRepository;

    public StudyActivityNo saveStudyActivity(StudyActivityRequest studyActivityRequest) {
        checkValidRequest(studyActivityRequest);
        return studyActivityRepository.save(studyActivityRequest.toEntity()).getId();
    }

    public void updateStudyActivity(StudyActivityNo id, StudyActivityRequest request) {
        checkValidRequest(request);
        getEntity(id)
                .updateStudyActivity(
                        request.getTitle(),
                        request.getDescription(),
                        request.getAssignment(),
                        request.getWeek(),
                        request.getPlace(),
                        request.getStudyParticipants(),
                        request.getStudyTime());
    }

    public void deleteStudyActivity(StudyActivityNo id) {
        getEntity(id).deleteStudyActivity();
    }

    private void checkValidRequest(StudyActivityRequest request) {
        checkStudyTime(request);
        checkParticipantDuplicated(request.getStudyParticipants());
    }

    private void checkStudyTime(StudyActivityRequest studyActivityRequest) {
        studyActivityRequest.getStudyTime().isValidStudyTime();
    }

    private void checkParticipantDuplicated(List<Long> studyParticipants) {
        if (studyParticipants.size() != getRequestCount(studyParticipants)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<Long> studyGroupParticipants) {
        return studyGroupParticipants.stream().distinct().count();
    }

    private StudyActivity getEntity(StudyActivityNo id) {
        return studyActivityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
