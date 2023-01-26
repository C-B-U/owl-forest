package com.cbu.backend.bookreview.query.api;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;
import com.cbu.backend.bookreview.query.infra.BookReviewDao;
import com.cbu.backend.bookreview.query.infra.BookReviewQueryOption;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book-reviews")
public class BookReviewQueryController {
    private final BookReviewDao bookReviewDao;

    @GetMapping
    public ResponseEntity<List<BookReviewSummaryResponse>> getAll(Pageable pageable, @RequestParam BookReviewQueryOption param) {
        return ResponseEntity.ok(bookReviewDao.findSummaryAll(pageable, param));
    }

    @GetMapping("{id}")
    public ResponseEntity<BookReviewResponse> getById(@PathVariable BookReviewNo id) {
        BookReviewResponse result =
                bookReviewDao.findResponseById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(result);
    }
}
