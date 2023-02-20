package com.cbu.backend.bookreview;

import com.cbu.backend.book.Book;
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
public class BookReview implements Auditable {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Member writer;

    @Column(nullable = false)
    private String title;

    @Lob private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Book book;

    @Column(nullable = false)
    private Integer likeCount = 0;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private Integer difficulty;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public BookReview(
            Member writer,
            String title,
            String content,
            Book book,
            Integer score,
            Integer difficulty) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.book = book;
        this.score = score;
        this.difficulty = difficulty;
        this.baseTime = new BaseTime();
    }

    public void update(String title, String content, Book book, Integer score, Integer difficulty) {
        this.title = title;
        this.content = content;
        this.book = book;
        this.score = score;
        this.difficulty = difficulty;
    }
}
