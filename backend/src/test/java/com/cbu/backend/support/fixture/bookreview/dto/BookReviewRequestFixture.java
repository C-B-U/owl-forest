package com.cbu.backend.support.fixture.bookreview.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookRequest;
import com.cbu.backend.bookreview.command.domain.BookReviewRequest;
import com.cbu.backend.support.fixture.book.dto.BookRequestFixture;

public enum BookReviewRequestFixture {
    SAMPLE1(
            BookRequestFixture.HONGGILDONG.getBookRequest(),
            new AccountNo(),
            "title",
            "content",
            10,
            10),
    SAMPLE2(
            BookRequestFixture.HERRY_POTTER.getBookRequest(),
            new AccountNo(),
            "title2",
            "content2",
            10,
            10);
    private final BookRequest book;
    private final AccountNo writer;
    private final String title;
    private final String content;
    private final Integer score;
    private final Integer difficulty;

    BookReviewRequestFixture(
            BookRequest book,
            AccountNo writer,
            String title,
            String content,
            Integer score,
            Integer difficulty) {
        this.book = book;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.score = score;
        this.difficulty = difficulty;
    }

    public BookReviewRequest getBookReviewRequest() {
        return new BookReviewRequest(book, title, content, score, difficulty);
    }
}
