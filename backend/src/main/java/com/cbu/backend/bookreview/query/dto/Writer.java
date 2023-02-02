package com.cbu.backend.bookreview.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Writer {
    private UUID id;
    private String nickname;

    @QueryProjection
    public Writer(UUID id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
