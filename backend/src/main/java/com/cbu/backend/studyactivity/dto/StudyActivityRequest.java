package com.cbu.backend.studyactivity.dto;

import com.cbu.backend.studyactivity.StudyTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @NotEmpty private List<UUID> studyParticipants = new ArrayList<>();
    private Long studyGroupId;
    private StudyTime studyTime;
}
