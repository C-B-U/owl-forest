package com.cbu.backend.studyactivity.dto;

import com.cbu.backend.studyactivity.StudyTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyTimeResponse {
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;

    public StudyTimeResponse(StudyTime studyTime) {
        startDate = studyTime.getStartTime().toLocalDate();
        startTime = studyTime.getStartTime().toLocalTime();
        endDate = studyTime.getEndTime().toLocalDate();
        endTime = studyTime.getEndTime().toLocalTime();
    }
}
