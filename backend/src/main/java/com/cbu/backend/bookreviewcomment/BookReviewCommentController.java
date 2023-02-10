package com.cbu.backend.bookreviewcomment;

import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentRequest;
import com.cbu.backend.bookreviewcomment.dto.BookReviewCommentResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book-review-comments")
public class BookReviewCommentController {
    private final BookReviewCommentService bookReviewCommentService;

    @PostMapping
    public ResponseEntity<Void> saveBookReviewComment(@RequestBody BookReviewCommentRequest req) {
        bookReviewCommentService.save(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<BookReviewCommentResponse>> getByBookReviewID(
            @RequestParam Long bookReviewId) {
        return ResponseEntity.ok(bookReviewCommentService.findByBookReviewId(bookReviewId));
    }
}
