package com.cbu.backend.bookborrow;

import com.cbu.backend.member.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
    List<BookBorrow> findAllByBookTitleContaining(String name);

    List<BookBorrow> findAllByBorrower(Member borrower);

    List<BookBorrow> findAllByLender(Member lender);
}
