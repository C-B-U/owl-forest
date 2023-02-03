package com.cbu.backend.studyactivitylog.command.service;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLog;
import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLogNo;
import com.cbu.backend.studyactivitylog.command.dto.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.command.infra.StudyActivityLogRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyActivityLogService {

    private final StudyActivityLogRepository studyActivityLogRepository;

    public StudyActivityLogNo saveStudyActivityLog(
            StudyActivityLogRequest studyActivityLogRequest) {
        checkValidRequest(studyActivityLogRequest);
        return studyActivityLogRepository.save(studyActivityLogRequest.toEntity()).getId();
    }

    public void updateStudyActivityLog(StudyActivityLogNo id, StudyActivityLogRequest request) {
        checkValidRequest(request);
        getEntity(id)
                .updateStudyActivityLog(
                        request.getTitle(),
                        request.getDescription(),
                        request.getAssignment(),
                        request.getWeek(),
                        request.getPlace(),
                        request.getStudyParticipants(),
                        request.getStudyTime());
    }

    public void deleteStudyActivityLog(StudyActivityLogNo id) {
        getEntity(id).deleteStudyActivityLog();
    }

    private void checkValidRequest(StudyActivityLogRequest request) {
        checkStudyTime(request);
        checkParticipantDuplicated(request.getStudyParticipants());
    }

    private void checkStudyTime(StudyActivityLogRequest studyActivityLogRequest) {
        studyActivityLogRequest.getStudyTime().isValidStudyTime();
    }

    private void checkParticipantDuplicated(List<AccountNo> studyParticipants) {
        if (studyParticipants.size() != getRequestCount(studyParticipants)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<AccountNo> studyGroupParticipants) {
        return studyGroupParticipants.stream().distinct().count();
    }

    private StudyActivityLog getEntity(StudyActivityLogNo id) {
        return studyActivityLogRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
