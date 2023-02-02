package com.cbu.backend.bookreview.query.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BookDetail {
    private UUID id;
    private String title;
    private String author;
    private String publisher;
    private String imageUrl;

    @QueryProjection
    public BookDetail(UUID id, String title, String author, String publisher, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
    }
}
