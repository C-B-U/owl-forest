package com.cbu.backend.global;

import lombok.Getter;

@Getter
public class ResponseBody<T> {
    private final String code;

    private final String message;

    private T result;

    public ResponseBody(ResponseStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }
    public ResponseBody(ResponseStatus status, T result) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.result = result;
    }

}
