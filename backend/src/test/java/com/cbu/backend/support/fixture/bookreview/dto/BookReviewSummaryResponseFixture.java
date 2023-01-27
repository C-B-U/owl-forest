package com.cbu.backend.support.fixture.bookreview.dto;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.dto.BookSummary;
import com.cbu.backend.bookreview.query.dto.Writer;

import java.time.LocalDateTime;

public enum BookReviewSummaryResponseFixture {
    SAMPLE1(
            new BookReviewNo(),
            WriterFixture.SAMPLE1.toWriter(),
            "제목 1",
            BookSummaryFixture.HONGGILDONG.toBookSummary(),
            5,
            5,
            5,
            LocalDateTime.now()),
    SAMPLE2(
            new BookReviewNo(),
            WriterFixture.SAMPLE2.toWriter(),
            "제목 2",
            BookSummaryFixture.HONGGILDONG.toBookSummary(),
            5,
            5,
            5,
            LocalDateTime.now()),
    SAMPLE3(
            new BookReviewNo(),
            WriterFixture.SAMPLE1.toWriter(),
            "제목 3",
            BookSummaryFixture.HERRY_POTTER.toBookSummary(),
            5,
            5,
            5,
            LocalDateTime.now());

    private final BookReviewNo id;
    private final Writer writer;
    private final String title;
    private final BookSummary book;
    private final Integer likeCount;
    private final Integer score;
    private final Integer difficulty;
    private final LocalDateTime createdAt;

    BookReviewSummaryResponseFixture(
            BookReviewNo id,
            Writer writer,
            String title,
            BookSummary book,
            Integer likeCount,
            Integer score,
            Integer difficulty,
            LocalDateTime createdAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.book = book;
        this.likeCount = likeCount;
        this.score = score;
        this.difficulty = difficulty;
        this.createdAt = createdAt;
    }

    public BookReviewSummaryResponse toBookReviewSummaryResponse() {
        return new BookReviewSummaryResponse(
                id, writer, title, book, likeCount, score, difficulty, createdAt);
    }
}
