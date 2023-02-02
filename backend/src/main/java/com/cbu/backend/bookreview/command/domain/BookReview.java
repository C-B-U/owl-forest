package com.cbu.backend.bookreview.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.global.BaseTime;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookReview {
    @EmbeddedId private BookReviewNo id;

    @Column(name="writer_id", nullable = false)
    private AccountNo writer;

    @Column(nullable = false)
    private String title;

    @Lob private String content;

    @Column(nullable = false)
    @Embedded
    private BookNo bookId;

    @Column(nullable = false)
    private Integer likeCount = 0;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private Integer difficulty;

    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public BookReview(
            BookReviewNo id,
            AccountNo writer,
            String title,
            String content,
            BookNo bookId,
            Integer score,
            Integer difficulty) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.bookId = bookId;
        this.baseTime = new BaseTime();
        this.score = score;
        this.difficulty = difficulty;
    }
}
