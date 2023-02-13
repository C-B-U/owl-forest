package com.cbu.backend.bookborrow;

import com.cbu.backend.book.Book;
import com.cbu.backend.member.domain.Member;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookBorrow {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    private String location;
    private LocalDate endDate;
}
