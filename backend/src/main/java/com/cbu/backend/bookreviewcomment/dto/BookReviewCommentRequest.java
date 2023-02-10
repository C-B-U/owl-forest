package com.cbu.backend.bookreviewcomment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewCommentRequest {
    @NotBlank private Long bookReviewId;
    private Long parentId;
    @NotBlank private String content;
}
