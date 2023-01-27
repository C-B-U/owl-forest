package com.cbu.backend.support.fixture.bookreview.dto;

import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.bookreview.query.dto.BookDetail;

public enum BookDetailFixture {
    HERRY_POTTER(new BookNo(), "해리포터", "조엔 롤링", "국정원", "aaa.bb.com"),

    HONGGILDONG(new BookNo(), "홍길동전", "조엔 롤링", "국정원", "aaa.bb.com");
    private final BookNo id;
    private final String title;
    private final String author;
    private final String publisher;
    private final String imageUrl;

    BookDetailFixture(BookNo id, String title, String author, String publisher, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
    }

    public BookDetail toBookDetail() {
        return new BookDetail(id, title, author, publisher, imageUrl);
    }
}
