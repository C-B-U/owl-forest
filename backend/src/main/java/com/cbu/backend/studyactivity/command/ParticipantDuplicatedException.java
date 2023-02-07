package com.cbu.backend.studyactivity.command;

public class ParticipantDuplicatedException extends IllegalArgumentException {
    private static final String MESSAGE = "스터디 참여자 중 중복 멤버가 있습니다.";

    public ParticipantDuplicatedException() {
        super(MESSAGE);
    }
}
