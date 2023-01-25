package com.cbu.backend.studyactivitylog.command.service;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLogNo;
import com.cbu.backend.studyactivitylog.command.dto.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.command.infra.StudyActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyActivityLogService {

    private final StudyActivityLogRepository studyActivityLogRepository;

    public StudyActivityLogNo saveStudyActivityLog(StudyActivityLogRequest studyActivityLogRequest) {
        checkStudyTime(studyActivityLogRequest);
        checkParticipantDuplicated(studyActivityLogRequest.getStudyParticipants());
        return studyActivityLogRepository.save(studyActivityLogRequest.toEntity()).getId();
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
}
