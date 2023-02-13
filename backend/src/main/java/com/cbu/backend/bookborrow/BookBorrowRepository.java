package com.cbu.backend.bookborrow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
    List<BookBorrow> findAllByBookTitleContaining(String name);
}
