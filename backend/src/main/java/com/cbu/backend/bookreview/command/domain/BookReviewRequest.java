package com.cbu.backend.bookreview.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewRequest {
    private BookRequest book;
    @Setter private AccountNo writer;
    private String title;
    private String content;
    private Integer score;
    private Integer difficulty;
}
