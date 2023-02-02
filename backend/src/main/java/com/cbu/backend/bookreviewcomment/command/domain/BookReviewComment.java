package com.cbu.backend.bookreviewcomment.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.global.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookReviewComment {
    @EmbeddedId
    private BookReviewCommentNo id;

    @Column(nullable = false)
    private AccountNo writer;
    private BookReviewCommentNo parent;
    @Column(nullable = false)
    private BookReviewNo bookReviewId;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private BaseTime baseTime;


    @Builder
    public BookReviewComment(BookReviewCommentNo id, AccountNo writer, BookReviewCommentNo parent, BookReviewNo bookReviewId, String content) {
        this.id = id;
        this.writer = writer;
        this.parent = parent;
        this.bookReviewId = bookReviewId;
        this.content = content;
        this.baseTime = new BaseTime();
    }
}
