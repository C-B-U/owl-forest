package com.cbu.backend.bookreview.query.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookReviewSummaryResponse {
    private BookReviewNo id;
    private AccountNo writer;
    private String title;
    private BookSummary book;
    private Integer likeCount;
    private Integer score;
    private Integer difficulty;
    private LocalDateTime createdAt;

    @QueryProjection
    public BookReviewSummaryResponse(BookReviewNo id, AccountNo writer, String title, BookSummary book, Integer likeCount, Integer score, Integer difficulty, LocalDateTime createdAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.book = book;
        this.likeCount = likeCount;
        this.score = score;
        this.difficulty = difficulty;
        this.createdAt = createdAt;
    }
}
