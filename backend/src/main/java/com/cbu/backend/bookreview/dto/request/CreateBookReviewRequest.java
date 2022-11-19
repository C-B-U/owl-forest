package com.cbu.backend.bookreview.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateBookReviewRequest {

    private Long bookId;
    private Long writerId;
    private String title;
    private String review;
    private double star;
    private double level;
    private Boolean like;

}
