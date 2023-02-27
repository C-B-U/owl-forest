package com.cbu.backend.bookborrow;

import com.cbu.backend.book.Book;
import com.cbu.backend.global.audit.AuditListener;
import com.cbu.backend.global.audit.Auditable;
import com.cbu.backend.global.audit.BaseTime;
import com.cbu.backend.global.audit.SoftDeleteSupport;
import com.cbu.backend.member.domain.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Getter
@Entity
@SoftDeleteSupport
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookBorrow implements Auditable {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "lender_id")
    private Member lender;

    private String location;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_id")
    private Member borrower;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    private String kakaoUrl;

    public BookBorrow(
            Book book,
            Member lender,
            String location,
            LocalDate endDate,
            Member borrower,
            String kakaoUrl) {
        this.book = book;
        this.lender = lender;
        this.location = location;
        this.endDate = endDate;
        this.borrower = borrower;
        this.kakaoUrl = kakaoUrl;
    }

    public void borrow(Member member) {
        this.borrower = member;
    }

    public void returnBook() {
        this.borrower = null;
    }
}
