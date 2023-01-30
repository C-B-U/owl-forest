package com.cbu.backend.bookreview.command.service;

import com.cbu.backend.book.command.domain.BookNo;
import com.cbu.backend.book.command.domain.BookRequest;
import com.cbu.backend.book.command.service.BookService;
import com.cbu.backend.bookreview.command.domain.BookReview;
import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.command.domain.BookReviewRequest;
import com.cbu.backend.bookreview.command.infra.BookReviewRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookService bookService;

    public BookReviewNo saveBookReview(BookReviewRequest req) {
        BookRequest bookRequest = req.getBook().toBookRequest(req.getWriter());
        BookNo bookID = bookService.saveIfNotExists(bookRequest);
        return bookReviewRepository
                .save(
                        BookReview.builder()
                                .id(new BookReviewNo())
                                .writer(req.getWriter())
                                .title(req.getTitle())
                                .content(req.getContent())
                                .bookId(bookID)
                                .score(req.getScore())
                                .content(req.getContent())
                                .build())
                .getId();
    }
}
