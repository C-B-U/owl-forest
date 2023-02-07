package com.cbu.backend.studyactivity.command.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyActivityResponse {
    private String title;
    private String description;
    private String assignment;
    private Integer week;
    private String place;
    private List<StudyParticipantsResponse> studyParticipants;
}
