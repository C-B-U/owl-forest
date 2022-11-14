package com.cbu.backend.bookreview.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BookReviewResponse {

    private Long id;

    private Long bookId;
    private Long writerId;
    private String detailReview;
    private String simpleReview;
    private double starPoint;
    private double starLevel;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}
