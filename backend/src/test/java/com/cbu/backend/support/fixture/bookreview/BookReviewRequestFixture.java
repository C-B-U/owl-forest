package com.cbu.backend.support.fixture.bookreview;

import com.cbu.backend.book.BookRequest;
import com.cbu.backend.bookreview.dto.BookReviewRequest;
import com.cbu.backend.support.fixture.book.BookRequestFixture;

public enum BookReviewRequestFixture {
    SAMPLE1(BookRequestFixture.HATE.toDto(), "제목1", "내용1", 5, 5),
    SAMPLE2(BookRequestFixture.HATE.toDto(), "제목2", "내용2", 5, 5),
    SAMPLE3(BookRequestFixture.SPRING.toDto(), "제목3", "내용3", 5, 5),
    SAMPLE4(BookRequestFixture.SPRING.toDto(), "제목4", "내용4", 5, 5);
    private final BookRequest book;
    private final String title;
    private final String content;
    private final Integer score;
    private final Integer difficulty;

    BookReviewRequestFixture(BookRequest book, String title, String content, Integer score, Integer difficulty) {
        this.book = book;
        this.title = title;
        this.content = content;
        this.score = score;
        this.difficulty = difficulty;
    }

    public BookReviewRequest toDto() {
        return new BookReviewRequest(book, title, content, score, difficulty);
    }
}
