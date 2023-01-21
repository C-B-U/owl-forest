package com.cbu.backend.bookreview.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookReviewRequest {
    private BookRequest book;
    private AccountNo writer;
    private String title;
    private String content;
    private Integer score;
    private Integer difficulty;

    public BookReviewRequest(
            BookRequest book, String title, String content, Integer score, Integer difficulty) {
        this.book = book;
        this.title = title;
        this.content = content;
        this.score = score;
        this.difficulty = difficulty;
    }

    public BookReviewRequest toBookReviewRequest(AccountNo writer) {
        return new BookReviewRequest(book, writer, title, content, score, difficulty);
    }
}
