package com.cbu.backend.studyactivitylog.command.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyTime {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public StudyTime(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void isValidStudyTime() {
        if (startTime.isBefore(endTime) && endTime.isBefore(LocalDateTime.now())) {
            throw new IllegalStudyTimeException();
        }
    }
}
