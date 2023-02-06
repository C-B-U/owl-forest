package com.cbu.backend.studyactivity.command.dto;

import com.cbu.backend.studyactivity.command.domain.StudyActivity;
import com.cbu.backend.studyactivity.command.domain.StudyTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyActivityRequest {
    @NotBlank private String title;
    @NotBlank private String description;
    private String assignment;
    private Integer week;
    private String place;

    @NotEmpty private List<Long> studyParticipants = new ArrayList<>();
    private StudyTime studyTime;

    public StudyActivity toEntity() {
        return null;
    }
}
