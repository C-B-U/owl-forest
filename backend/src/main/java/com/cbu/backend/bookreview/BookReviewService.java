package com.cbu.backend.bookreview;

import com.cbu.backend.book.Book;
import com.cbu.backend.book.BookService;
import com.cbu.backend.bookreview.dto.BookReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookService bookService;

    public Long saveBookReview(BookReviewRequest req) {
       // SecurityContextHolder.
       // BookRequest bookRequest = req.getBook().toBookRequest(req.getWriter());
        Book book = bookService.saveIfNotExists(req.getBook());
        return bookReviewRepository
                .save(
                        BookReview.builder()
                                .title(req.getTitle())
                                .content(req.getContent())
                                .book(book)
                                .score(req.getScore())
                                .content(req.getContent())
                                .build())
                .getId();
    }
}
