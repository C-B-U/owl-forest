package com.cbu.backend.bookreview.query.api;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.infra.BookReviewDao;
import com.cbu.backend.bookreview.query.infra.BookReviewQueryOption;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("book-reviews")
public class BookReviewQueryController {
    private final BookReviewDao bookReviewDao;

    @GetMapping
    public ResponseEntity<List<BookReviewSummaryResponse>> getAll(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false) BookReviewQueryOption param) {
        return ResponseEntity.ok(bookReviewDao.findSummaryAll(pageable, param));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReviewResponse> getById(@PathVariable String id) {
        BookReviewResponse result =
                bookReviewDao
                        .findResponseById(new BookReviewNo(id))
                        .orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(result);
    }
}
