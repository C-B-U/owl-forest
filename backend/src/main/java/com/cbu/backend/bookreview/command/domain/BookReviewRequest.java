package com.cbu.backend.bookreview.command.domain;

import com.cbu.backend.book.command.domain.BookRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewRequest {
    private BookRequest book;
}
