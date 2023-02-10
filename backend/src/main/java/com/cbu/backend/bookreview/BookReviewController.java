package com.cbu.backend.bookreview;

import com.cbu.backend.bookreview.dto.BookReviewRequest;
import com.cbu.backend.bookreview.dto.BookReviewResponse;
import com.cbu.backend.bookreview.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.repository.BookReviewQueryOption;
import com.cbu.backend.global.RequestObjectParam;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("book-reviews")
@RequiredArgsConstructor
public class BookReviewController {
    private final BookReviewService bookReviewService;

    @PostMapping
    public ResponseEntity<BookReviewResponse> saveBookReview(
            @RequestBody @Valid BookReviewRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookReviewService.saveBookReview(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookReviewSummaryResponse>> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestObjectParam BookReviewQueryOption param) {
        return ResponseEntity.ok(bookReviewService.findAll(pageable, param));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReviewResponse> getById(@PathVariable Long id) {
        BookReviewResponse result = bookReviewService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putById(
            @PathVariable Long id, @RequestBody @Valid BookReviewRequest dto) {
        bookReviewService.update(id, dto);
        return ResponseEntity.noContent().build();
    }
}
