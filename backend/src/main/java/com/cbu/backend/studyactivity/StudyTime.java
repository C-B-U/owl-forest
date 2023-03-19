package com.cbu.backend.studyactivity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyTime {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public StudyTime(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void validStudyTime() {
        if (startTime.isAfter(endTime) || endTime.isAfter(LocalDateTime.now())) {
            throw new IllegalStudyTimeException();
        }
    }
}
