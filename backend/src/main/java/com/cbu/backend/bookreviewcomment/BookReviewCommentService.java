package com.cbu.backend.bookreviewcomment;

import com.cbu.backend.bookreview.BookReview;
import com.cbu.backend.bookreview.BookReviewService;
import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentRequest;
import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentResponse;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReviewCommentService {
    private final BookReviewCommentMapper bookReviewCommentMapper;
    private final BookReviewCommentRepository bookReviewCommentRepository;
    private final BookReviewService bookReviewService;
    private final AuthService authService;

    public Long save(BookReviewCommentRequest req) {
        BookReview bookReview = bookReviewService.getEntity(req.getBookReviewId());
        Member writer = authService.getLoginUser();
        return bookReviewCommentRepository.save(bookReviewCommentMapper.toEntity(req, bookReview, writer)).getId();
    }

    public List<BookReviewCommentResponse> findByBookReviewId(Long bookReviewId) {
        return bookReviewCommentRepository.findAllByBookReviewId(bookReviewId).stream().map(bookReviewCommentMapper::toDto).toList();
    }
}
