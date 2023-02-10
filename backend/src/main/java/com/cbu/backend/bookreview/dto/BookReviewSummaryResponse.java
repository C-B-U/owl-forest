package com.cbu.backend.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BookReviewSummaryResponse {
    private Long id;
    private Writer writer;
    private String title;
    private BookSummary book;
    private Integer likeCount;
    private Integer score;
    private Integer difficulty;
    private LocalDateTime createdAt;
}
