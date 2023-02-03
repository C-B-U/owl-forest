package com.cbu.backend.studyactivitylog.command.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLog;
import com.cbu.backend.studyactivitylog.command.domain.StudyTime;

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
public class StudyActivityLogRequest {
    @NotBlank private String title;
    @NotBlank private String description;
    private String assignment;
    private Integer week;
    private String place;

    @NotEmpty private List<AccountNo> studyParticipants = new ArrayList<>();
    private StudyTime studyTime;

    public StudyActivityLog toEntity() {
        return StudyActivityLog.builder()
                .title(title)
                .description(description)
                .week(week)
                .place(place)
                .studyParticipants(studyParticipants)
                .studyTime(studyTime)
                .build();
    }
}
