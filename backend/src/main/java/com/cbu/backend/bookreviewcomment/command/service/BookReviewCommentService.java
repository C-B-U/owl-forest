package com.cbu.backend.bookreviewcomment.command.service;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreviewcomment.command.domain.BookReviewComment;
import com.cbu.backend.bookreviewcomment.command.domain.BookReviewCommentNo;
import com.cbu.backend.bookreviewcomment.command.domain.BookReviewCommentRequest;
import com.cbu.backend.bookreviewcomment.command.infra.BookReviewCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookReviewCommentService {
    private final BookReviewCommentRepository bookReviewCommentRepository;

    public BookReviewCommentNo saveBookReviewComment(BookReviewCommentRequest req) {
        BookReviewComment.BookReviewCommentBuilder commentBuilder = BookReviewComment.builder()
                .id(new BookReviewCommentNo())
                .writer(req.getWriter())
                .bookReviewId(new BookReviewNo(req.getBookReviewId()))
                .content(req.getContent());
        Optional.ofNullable(req.getParentId())
                .ifPresent(pi -> commentBuilder.parent(new BookReviewCommentNo(req.getParentId())));
        
        return bookReviewCommentRepository.save(
                        commentBuilder.build())
                .getId();
    }
}
