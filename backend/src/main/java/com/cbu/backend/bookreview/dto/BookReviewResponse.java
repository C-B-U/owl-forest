package com.cbu.backend.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BookReviewResponse {
    private Long id;
    private Writer writer;
    private String title;
    private String content;
    private BookDetail book;
    private Integer likeCount;
    private Integer score;
    private Integer difficulty;
    private LocalDateTime createdAt;
}
