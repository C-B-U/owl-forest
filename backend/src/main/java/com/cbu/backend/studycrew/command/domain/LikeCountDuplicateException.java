package com.cbu.backend.studycrew.command.domain;

public class LikeCountDuplicateException extends IllegalStateException {
    private static final String MESSAGE = "이미 처리된 좋아요 요청입니다.";

    public LikeCountDuplicateException() {
        super(MESSAGE);
    }
}
