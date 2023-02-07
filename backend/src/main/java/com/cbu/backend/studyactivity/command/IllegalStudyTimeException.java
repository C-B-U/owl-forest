package com.cbu.backend.studyactivity.command;

public class IllegalStudyTimeException extends IllegalArgumentException {
    private static final String MESSAGE = "스터디 시간이 잘못되었습니다.";

    public IllegalStudyTimeException() {
        super(MESSAGE);
    }
}
