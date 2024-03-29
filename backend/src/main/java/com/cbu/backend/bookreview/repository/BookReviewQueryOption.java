package com.cbu.backend.bookreview.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewQueryOption {
    private String title;
    private String content;
    private String bookname;
    private String writer;
}
