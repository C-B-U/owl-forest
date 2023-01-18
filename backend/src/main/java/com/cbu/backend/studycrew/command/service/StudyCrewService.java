package com.cbu.backend.studycrew.command.service;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;
import com.cbu.backend.studycrew.command.infra.StudyCrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyCrewService {

    private final StudyCrewRepository studyCrewRepository;

    public StudyCrewNo save(StudyCrewRequest studyCrewRequest) {
        checkParticipantDuplicated(studyCrewRequest.getParticipants());
        return studyCrewRepository.save(studyCrewRequest.toEntity()).getId();
    }

    private void checkParticipantDuplicated(List<AccountNo> studyCrewParticipants) {
        if (studyCrewParticipants.size() != getRequestCount(studyCrewParticipants)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<AccountNo> studyCrewParticipants) {
        return studyCrewParticipants.stream().distinct().count();
    }
}
