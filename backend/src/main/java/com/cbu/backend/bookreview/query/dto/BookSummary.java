package com.cbu.backend.bookreview.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

import java.util.UUID;

@Getter
public class BookSummary {
    private UUID id;
    private String title;
    private String imageUrl;

    @QueryProjection
    public BookSummary(UUID id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
    }
}
