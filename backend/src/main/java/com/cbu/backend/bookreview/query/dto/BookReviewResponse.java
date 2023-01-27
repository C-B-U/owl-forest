package com.cbu.backend.bookreview.query.dto;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookReviewResponse {
    private BookReviewNo id;
    private Writer writer;
    private String title;
    private String content;
    private BookDetail book;
    private Integer likeCount;
    private Integer score;
    private Integer difficulty;
    private LocalDateTime createdAt;

    @QueryProjection
    public BookReviewResponse(
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
}
