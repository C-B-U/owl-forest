package com.cbu.backend.bookreview.dto;

import com.cbu.backend.book.BookRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookReviewRequest {
    private BookRequest book;
    private String title;
    private String content;
    private Integer score;
    private Integer difficulty;
}
