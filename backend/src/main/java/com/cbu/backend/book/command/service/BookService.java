package com.cbu.backend.book.command.service;

import com.cbu.backend.book.command.domain.Book;
import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.book.command.domain.BookRequest;
import com.cbu.backend.book.command.infra.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookNo saveIfNotExists(BookRequest req) {
        return bookRepository.findById_Isbn(req.getIsbn())
                .orElseGet(() -> saveBook(req))
                .getId();
    }

    private Book saveBook(BookRequest req) {
        BookNo bookId = new BookNo(req.getIsbn());
        return bookRepository.save(Book.builder()
                        .id(bookId)
                        .title(req.getTitle())
                        .author(req.getAuthor())
                        .imageUrl(req.getImageUrl())
                        .price(req.getPrice())
                        .publishAt(req.getPublishAt())
                        .publisher(req.getPublisher())
                        .registrant(req.getRegistrant())
                        .build());
    }
}
