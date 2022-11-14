package com.cbu.backend.bookReview.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BookReviewResponseDTO {

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
