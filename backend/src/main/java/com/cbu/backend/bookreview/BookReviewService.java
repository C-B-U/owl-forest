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

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookService bookService;
    private final AuthService authService;
    private final BookReviewMapper bookReviewMapper;

    @Transactional
    public BookReviewResponse saveBookReview(BookReviewRequest req) {
        Member loginUser = authService.getLoginUser();
        Book book = bookService.saveIfNotExists(req.getBook());
        return bookReviewMapper.toDto(
                bookReviewRepository.save(bookReviewMapper.toEntity(req, book, loginUser)));
    }

    public List<BookReviewSummaryResponse> findAll(Pageable pageable, BookReviewQueryOption param) {
        List<BookReview> bookReviews = bookReviewRepository.findAllBy(pageable, param);
        return bookReviews.stream().map(bookReviewMapper::toSummaryDto).toList();
    }

    public BookReview getEntity(Long id) {
        return bookReviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public BookReviewResponse findById(Long id) {
        BookReview bookReview = getEntity(id);
        return bookReviewMapper.toDto(bookReview);
    }

    @Transactional
    public void update(Long id, BookReviewRequest dto) {
        Book book = bookService.saveIfNotExists(dto.getBook());
        getEntity(id)
                .update(
                        dto.getTitle(),
                        dto.getContent(),
                        book,
                        dto.getScore(),
                        dto.getDifficulty());
    }
}
