package com.cbu.backend.book.command.infra;

import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, BookNo> {
    Optional<Book> findById_Isbn(String isbn);
}
