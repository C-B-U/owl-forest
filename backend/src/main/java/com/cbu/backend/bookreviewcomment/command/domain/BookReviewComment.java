package com.cbu.backend.bookreviewcomment.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.global.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookReviewComment {
    @EmbeddedId private BookReviewCommentNo id;

    @Column(nullable = false)
    private AccountNo writer;

    @AttributeOverride(name = "id", column = @Column(name = "parent_id", nullable = false))
    private BookReviewCommentNo parent;

    @Column(nullable = false)
    private BookReviewNo bookReview;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public BookReviewComment(
            BookReviewCommentNo id,
            AccountNo writer,
            BookReviewCommentNo parent,
            BookReviewNo bookReview,
            String content) {
        this.id = id;
        this.writer = writer;
        this.parent = parent;
        this.bookReview = bookReview;
        this.content = content;
        this.baseTime = new BaseTime();
    }
}
