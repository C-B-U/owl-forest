package com.cbu.backend.bookreview.query.api;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.infra.BookReviewDao;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book-reviews")
public class BookReviewQueryController {
    private final BookReviewDao bookReviewDao;

    @GetMapping
    public ResponseEntity<List<BookReviewSummaryResponse>> getAll() {
        return ResponseEntity.ok(bookReviewDao.findSummaryAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookReviewResponse> getById(@PathVariable BookReviewNo id) {
        BookReviewResponse result =
                bookReviewDao.findResponseById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(result);
    }
}
