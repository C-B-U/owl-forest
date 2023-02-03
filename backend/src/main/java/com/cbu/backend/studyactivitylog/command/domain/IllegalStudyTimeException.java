package com.cbu.backend.studyactivitylog.command.domain;

public class IllegalStudyTimeException extends IllegalArgumentException {
    private static final String MESSAGE = "스터디 시간이 잘못되었습니다.";

    public IllegalStudyTimeException() {
        super(MESSAGE);
    }
}
