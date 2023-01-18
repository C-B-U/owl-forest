package com.cbu.backend.studycrew.command.domain;

public enum StudyCrewStatus {
    ACTIVE("활동중"),
    FINISHED("활동종료");

    private final String korean;

    StudyCrewStatus(String korean) {
        this.korean = korean;
    }
}
