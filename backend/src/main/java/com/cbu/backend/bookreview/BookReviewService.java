package com.cbu.backend.bookreview;

import com.cbu.backend.book.Book;
import com.cbu.backend.book.BookService;
import com.cbu.backend.bookreview.dto.BookReviewRequest;
import com.cbu.backend.bookreview.dto.BookReviewResponse;
import com.cbu.backend.bookreview.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.repository.BookReviewQueryOption;
import com.cbu.backend.bookreview.repository.BookReviewRepository;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookService bookService;
    private final AuthService authService;
    private final BookReviewMapper bookReviewMapper;

    @Transactional
    public Long saveBookReview(BookReviewRequest req) {
        Member loginUser = authService.getLoginUser();
        Book book = bookService.saveIfNotExists(req.getBook());
        log.info("{} ", req.getBook().getIsbn());
        log.info("{}", book.getId());
        return bookReviewRepository.save(bookReviewMapper.toEntity(req, book, loginUser)).getId();
    }

    public List<BookReviewSummaryResponse> findAll(Pageable pageable, BookReviewQueryOption param) {
        List<BookReview> bookReviews = bookReviewRepository.findAllBy(pageable, param);
        return bookReviews.stream().map(bookReviewMapper::toSummaryDto).toList();
    }

    public BookReviewResponse findById(Long id) {
        BookReview bookReview =
                bookReviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return bookReviewMapper.toDto(bookReview);
    }
}
