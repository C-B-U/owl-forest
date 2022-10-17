package com.cbu.backend.global;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseFormat<T> {
    private final int code;
    private final String message;
    private T result;

    public ResponseFormat(HttpStatus status) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
    }

    public ResponseFormat(HttpStatus status, T result) {
        this.code = status.value();
        this.message = status.getReasonPhrase();
        this.result = result;
    }
}
