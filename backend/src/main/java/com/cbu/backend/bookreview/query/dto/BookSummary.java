package com.cbu.backend.bookreview.query.dto;

import com.cbu.backend.book.command.domain.BookNo;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

@Getter
public class BookSummary {
    private BookNo bookNo;
    private String title;
    private String imageUrl;

    @QueryProjection
    public BookSummary(BookNo bookNo, String title, String imageUrl) {
        this.bookNo = bookNo;
        this.title = title;
        this.imageUrl = imageUrl;
    }
}
