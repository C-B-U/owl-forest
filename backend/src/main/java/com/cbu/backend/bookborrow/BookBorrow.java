package com.cbu.backend.bookborrow;

import com.cbu.backend.book.Book;
import com.cbu.backend.member.domain.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

@Getter
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

    public BookBorrow(Book book, Member writer, String location, LocalDate endDate) {
        this.book = book;
        this.writer = writer;
        this.location = location;
        this.endDate = endDate;
    }
}
