package com.cbu.backend.studycrew.command.service;

import com.cbu.backend.studycrew.command.domain.StudyCrew;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;
import com.cbu.backend.studycrew.command.infra.StudyCrewRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyCrewService {

    private final StudyCrewRepository studyCrewRepository;

    public StudyCrewNo save(StudyCrewRequest studyCrewRequest) {
        StudyCrew studyCrew =
                StudyCrew.builder()
                        .name(studyCrewRequest.getName())
                        .description(studyCrewRequest.getDescription())
                        .studyCrewLeaderId(studyCrewRequest.getStudyCrewLeaderId())
                        .studyCrewParticipantIds(studyCrewRequest.getStudyCrewParticipantIds())
                        .build();

        return studyCrewRepository.save(studyCrew).getId();
    }
}
