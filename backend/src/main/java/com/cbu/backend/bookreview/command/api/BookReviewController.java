package com.cbu.backend.bookreview.command.api;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.command.domain.BookReviewRequest;
import com.cbu.backend.bookreview.command.service.BookReviewService;
import com.cbu.backend.config.security.oauth2.LoginUser;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book-reviews")
@RequiredArgsConstructor
public class BookReviewController {
    private final BookReviewService bookReviewService;

    @PostMapping
    public ResponseEntity<BookReviewNo> saveBookReview(
            @AuthenticationPrincipal LoginUser loginUser, @RequestBody BookReviewRequest dto) {
        dto.setWriter(loginUser.getAccountId());
        BookReviewNo bookReviewId = bookReviewService.saveBookReview(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookReviewId);
    }
}
