package com.cbu.backend.support.fixture.bookreview.entity;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.support.fixture.book.entity.BookFixture;

public enum BookReviewFixture {
    SAMPLE1(
            new BookReviewNo(),
            new AccountNo(),
            "제목 1",
            "내용 1",
            BookFixture.SAMPLE1.getId(),
            10,
            4,
            2,
            new BaseTime()),
    SAMPLE2(
            new BookReviewNo(),
            new AccountNo(),
            "제목 2",
            "내용 2",
            BookFixture.SAMPLE1.getId(),
            10,
            4,
            2,
            new BaseTime());
    private final BookReviewNo id;
    private final AccountNo writer;
    private final String title;
    private final String content;
    private final BookNo bookId;
    private final Integer likeCount;
    private final Integer score;
    private final Integer difficulty;
    private final BaseTime baseTime;

    BookReviewFixture(
            BookReviewNo id,
            AccountNo writer,
            String title,
            String content,
            BookNo bookId,
            Integer likeCount,
            Integer score,
            Integer difficulty,
            BaseTime baseTime) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.bookId = bookId;
        this.likeCount = likeCount;
        this.score = score;
        this.difficulty = difficulty;
        this.baseTime = baseTime;
    }

    public BookReview toEntity() {
        return new BookReview(id, writer, title, content, bookId, score, difficulty);
    }
}
