package com.cbu.backend.bookreview.query.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class BookReviewSummaryResponse {
    private UUID id;
    private Writer writer;
    private String title;
    private BookSummary book;
    private Integer likeCount;
    private Integer score;
    private Integer difficulty;
    private LocalDateTime createdAt;

    @QueryProjection
    public BookReviewSummaryResponse(
            UUID id,
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
}
