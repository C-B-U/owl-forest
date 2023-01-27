package com.cbu.backend.support.fixture.bookreview.dto;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookDetail;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.Writer;

import java.time.LocalDateTime;

public enum BookReviewResponseFixture {
    SAMPLE1(
            new BookReviewNo(),
            WriterFixture.SAMPLE1.toWriter(),
            "제목 1",
            "내용 1",
            BookDetailFixture.HONGGILDONG.toBookDetail(),
            5,
            5,
            5,
            LocalDateTime.now()),
    SAMPLE2(
            new BookReviewNo(),
            WriterFixture.SAMPLE2.toWriter(),
            "제목 2",
            "내용 2",
            BookDetailFixture.HONGGILDONG.toBookDetail(),
            5,
            5,
            5,
            LocalDateTime.now()),
    SAMPLE3(
            new BookReviewNo(),
            WriterFixture.SAMPLE1.toWriter(),
            "제목 3",
            "내용 3",
            BookDetailFixture.HERRY_POTTER.toBookDetail(),
            5,
            5,
            5,
            LocalDateTime.now());
    private final BookReviewNo id;
    private final Writer writer;
    private final String title;
    private final String content;
    private final BookDetail book;
    private final Integer likeCount;
    private final Integer score;
    private final Integer difficulty;
    private final LocalDateTime createdAt;

    BookReviewResponseFixture(
            BookReviewNo id,
            Writer writer,
            String title,
            String content,
            BookDetail book,
            Integer likeCount,
            Integer score,
            Integer difficulty,
            LocalDateTime createdAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.book = book;
        this.likeCount = likeCount;
        this.score = score;
        this.difficulty = difficulty;
        this.createdAt = createdAt;
    }

    public BookReviewResponse getBookReviewResponse() {
        return new BookReviewResponse(
                id, writer, title, content, book, likeCount, score, difficulty, createdAt);
    }
}
