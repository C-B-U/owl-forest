package com.cbu.backend.studycrew.query.dto;

import com.cbu.backend.studycrew.command.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyCrewResponse {
    private StudyCrewNo id;
    private String name;
    private String description;
    private LikeCount likeCount;
    private StudyCrewStatus studyCrewStatus;
    private StudyCrewMember studyCrewMember;

    public StudyCrewResponse(StudyCrew studyCrew) {
        this.id = studyCrew.getId();
        this.name = studyCrew.getName();
        this.description = studyCrew.getDescription();
        this.likeCount = studyCrew.getLikeCount();
        this.studyCrewStatus = studyCrew.getStudyCrewStatus();
        this.studyCrewMember = studyCrew.getStudyCrewMember();
    }
}
