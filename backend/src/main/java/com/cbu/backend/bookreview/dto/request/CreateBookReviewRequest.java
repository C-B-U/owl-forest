package com.cbu.backend.bookreview.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
