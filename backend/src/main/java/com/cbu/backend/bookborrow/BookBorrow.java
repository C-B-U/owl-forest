package com.cbu.backend.bookborrow;

import com.cbu.backend.book.Book;
import com.cbu.backend.config.audit.AuditListener;
import com.cbu.backend.config.audit.Auditable;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.domain.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Where;

import java.time.LocalDate;

import javax.persistence.*;

@Getter
@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookBorrow implements Auditable {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    private String location;
    private LocalDate endDate;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    public BookBorrow(Book book, Member writer, String location, LocalDate endDate) {
        this.book = book;
        this.writer = writer;
        this.location = location;
        this.endDate = endDate;
        this.baseTime = new BaseTime();
    }
}
