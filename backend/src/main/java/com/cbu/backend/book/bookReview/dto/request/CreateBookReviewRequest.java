package com.cbu.backend.bookReview.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CreateBookReviewRequest {

    private Long bookId;
    private Long writerId;
    private String detailReview;
    private String simpleReview;
    private double starPoint;
    private double starLevel;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

}
