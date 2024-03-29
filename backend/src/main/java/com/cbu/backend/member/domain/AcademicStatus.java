package com.cbu.backend.member.domain;

public enum AcademicStatus {
    ATTEND("재학"),
    ABSENCE("휴학"),
    GRADUATE("졸업");

    private final String korean;

    AcademicStatus(String korean) {
        this.korean = korean;
    }
}
