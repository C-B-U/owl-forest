package com.cbu.backend.bookreviewcomment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BookReviewCommentResponse {
    private Long id;
    private Writer writer;
    private String content;
    private LocalDateTime createdAt;

}
