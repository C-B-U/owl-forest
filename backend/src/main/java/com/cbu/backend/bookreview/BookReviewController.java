package com.cbu.backend.bookreview;

import com.cbu.backend.bookreview.dto.BookReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-reviews")
@RequiredArgsConstructor
public class BookReviewController {
    private final BookReviewService bookReviewService;

    @PostMapping
    public ResponseEntity<Long> saveBookReview(@RequestBody BookReviewRequest dto) {
        Long bookReviewId = bookReviewService.saveBookReview(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookReviewId);
    }
//    @GetMapping
//    public ResponseEntity<List<BookReviewSummaryResponse>> getAll(
//            @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
//            @RequestParam(required = false) BookReviewQueryOption param) {
//        return ResponseEntity.ok(bookReviewDao.findSummaryAll(pageable, param));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BookReviewResponse> getById(@PathVariable String id) {
//        BookReviewResponse result =
//                bookReviewService
//                        .findResponseById(new BookReviewNo(id))
//                        .orElseThrow(EntityNotFoundException::new);
//        return ResponseEntity.ok(result);
//    }
}
