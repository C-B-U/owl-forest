package com.cbu.backend.support.fixture.bookreview.dto;

import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.bookreview.query.dto.BookSummary;

public enum BookSummaryFixture {
    HERRY_POTTER(new BookNo(), "해리포터", "aaa.bb.com"),
    HONGGILDONG(new BookNo(), "홍길동전", "aaa.bb.com"),
    SIMCHUNG(new BookNo(), "심청전", "aaa.bb.com");

    private final BookNo id;
    private final String title;
    private final String imageUrl;

    BookSummaryFixture(BookNo id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public BookSummary toBookSummary() {
        return new BookSummary(id, title, imageUrl);
    }
}
