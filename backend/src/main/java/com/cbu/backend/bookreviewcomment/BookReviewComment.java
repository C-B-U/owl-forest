package com.cbu.backend.bookreviewcomment;

import com.cbu.backend.bookreview.BookReview;
import com.cbu.backend.config.audit.AuditListener;
import com.cbu.backend.config.audit.Auditable;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.domain.Member;

import lombok.*;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookReviewComment implements Auditable {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookReview bookReview;

    @Lob
    @Column(nullable = false)
    private String content;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public BookReviewComment(Member writer, BookReview bookReview, String content) {
        this.writer = writer;
        this.bookReview = bookReview;
        this.content = content;
        this.baseTime = new BaseTime();
    }
}
