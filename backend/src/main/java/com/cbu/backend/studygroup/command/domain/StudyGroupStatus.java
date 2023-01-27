package com.cbu.backend.studygroup.command.domain;

public enum StudyGroupStatus {
    ACTIVE("활동중"),
    FINISHED("활동종료");

    private final String korean;

    StudyGroupStatus(String korean) {
        this.korean = korean;
    }
}
