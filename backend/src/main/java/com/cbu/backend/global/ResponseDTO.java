package com.cbu.backend.global;

import lombok.Getter;

@Getter
public class ResponseDTO<T> {
    private final String code;

    private final String message;

    private T result;

    public ResponseDTO(ResponseStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }
    public ResponseDTO(ResponseStatus status, T result) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.result = result;
    }

}
