package com.cbu.backend.bookreviewcomment;

import com.cbu.backend.bookreview.BookReview;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.domain.Member;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookReviewComment {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private BookReviewComment parent;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookReview bookReview;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public BookReviewComment(
            Member writer, BookReviewComment parent, BookReview bookReview, String content) {
        this.writer = writer;
        this.parent = parent;
        this.bookReview = bookReview;
        this.content = content;
    }
}
