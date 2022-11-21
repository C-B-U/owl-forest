package com.cbu.backend.studyactivitylog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudyParticipantResponse {
    private Long id;
    private String name;
    private String major;
    private Integer grade;
    private String profileUrl;
}
