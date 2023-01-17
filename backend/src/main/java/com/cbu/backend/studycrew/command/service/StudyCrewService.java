package com.cbu.backend.studycrew.command.service;

import com.cbu.backend.studycrew.command.domain.StudyCrew;
import com.cbu.backend.studycrew.command.dto.StudyCrewResponse;
import com.cbu.backend.studycrew.command.infra.StudyCrewRepository;
import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyCrewService {

    private StudyCrewRepository studyCrewRepository;

    public StudyCrewResponse save(StudyCrewRequest studyCrewRequest) {
        StudyCrew studyCrew = StudyCrew.builder()
                .name(studyCrewRequest.getName())
                .description(studyCrewRequest.getDescription())
                .studyCrewLeaderId(studyCrewRequest.getStudyCrewLeaderId())
                .studyCrewParticipantIds(studyCrewRequest.getStudyCrewParticipantIds())
                .build();

        return new StudyCrewResponse(studyCrewRepository.save(studyCrew));
    }
}
