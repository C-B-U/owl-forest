package com.cbu.backend.bookreview.query.dto;

import com.cbu.backend.book.command.domain.BookNo;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

@Getter
public class BookDetail {
    private BookNo id;
    private String title;
    private String author;
    private String publisher;
    private String imageUrl;

    @QueryProjection
    public BookDetail(BookNo id, String title, String author, String publisher, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
    }
}
