package com.cbu.backend.book.command.infra;

import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, BookNo> {

    default BookNo nextNo() {
        return new BookNo(UUID.randomUUID());
    }
}
