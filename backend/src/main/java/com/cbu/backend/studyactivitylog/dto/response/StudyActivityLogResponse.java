package com.cbu.backend.studyactivitylog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
public class StudyActivityLogResponse {
    private Long id;
    private Integer week;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String place;
    private List<StudyParticipantResponse> teamMembers;
    private String title;
    private String description;
    private String assignment;
}
