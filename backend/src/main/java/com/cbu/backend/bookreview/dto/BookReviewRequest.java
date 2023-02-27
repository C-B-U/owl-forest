package com.cbu.backend.bookreview.dto;

import com.cbu.backend.book.BookRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookReviewRequest {
    @Valid private BookRequest book;
    @NotBlank private String title;
    private String content;
    @NotNull private Integer score;
    @NotNull private Integer difficulty;
}
