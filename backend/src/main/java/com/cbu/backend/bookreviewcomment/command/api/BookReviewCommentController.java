package com.cbu.backend.bookreviewcomment.command.api;

import com.cbu.backend.bookreviewcomment.command.domain.BookReviewCommentNo;
import com.cbu.backend.bookreviewcomment.command.domain.BookReviewCommentRequest;
import com.cbu.backend.bookreviewcomment.command.service.BookReviewCommentService;
import com.cbu.backend.config.security.oauth2.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book-review-comments")
@RequiredArgsConstructor
public class BookReviewCommentController {

    private final BookReviewCommentService bookReviewCommentService;

    @PostMapping
    public ResponseEntity<BookReviewCommentNo> save(@AuthenticationPrincipal LoginUser loginUser, @RequestBody BookReviewCommentRequest dto) {
        BookReviewCommentNo bookReviewCommentId = bookReviewCommentService.saveBookReviewComment(dto.toBookReviewRequest(loginUser.getAccountId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(bookReviewCommentId);
    }
}
