package com.cbu.backend.bookreview.controller;

import com.cbu.backend.bookreview.dto.request.CreateBookReviewRequest;
import com.cbu.backend.bookreview.dto.response.BookReviewResponse;
import com.cbu.backend.bookreview.service.BookReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cbu.backend.global.ResponseBody;
import com.cbu.backend.global.ResponseStatus;
import java.util.List;

@RestController
@RequestMapping("api/book-review")
public class BookReviewController {

    private BookReviewService bookReviewService;

    public BookReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    @PostMapping()
    public ResponseEntity<ResponseBody<BookReviewResponse>> createBookReview(
            @RequestBody CreateBookReviewRequest createBookReviewRequest) {
        BookReviewResponse saveBookReview = bookReviewService.save(createBookReviewRequest);
        ResponseBody<BookReviewResponse> responseBody
                = new ResponseBody<>(ResponseStatus.POST_BOOKREVIEW_SUCCESS, saveBookReview);

        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseBody<BookReviewResponse>> deleteBookReview(@PathVariable Long id) {
        BookReviewResponse deletedBookReview = bookReviewService.deleteById(id);
        ResponseBody<BookReviewResponse> responseBody = new ResponseBody<>(ResponseStatus.DELETE_BOOKREVIEW_SUCCESS, deletedBookReview);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping()
    public ResponseEntity<ResponseBody<List<BookReviewResponse>>> getBookReviewListAll() {
        List<BookReviewResponse> bookReviews = bookReviewService.getAll();
        ResponseBody<List<BookReviewResponse>> responseBody = new ResponseBody<>(ResponseStatus.GET_BOOKREVIEW_LIST_SUCCESS, bookReviews);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping()
    public ResponseEntity<ResponseBody<List<BookReviewResponse>>> getBookReviewByTitle(@RequestParam String title) {
        List<BookReviewResponse> bookReviews = bookReviewService.getAllByTitle(title);
        ResponseBody<List<BookReviewResponse>> responseBody = new ResponseBody<>(ResponseStatus.GET_BOOKREVIEW_LIST_SUCCESS, bookReviews);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseBody<BookReviewResponse>> getBookReviewById(@PathVariable Long id) {
        BookReviewResponse bookReview = bookReviewService.getById(id);
        ResponseBody<BookReviewResponse> responseBody = new ResponseBody<>(ResponseStatus.GET_BOOKREVIEW_SUCCESS, bookReview);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(params = "sortBy=star")
    public ResponseEntity<ResponseBody<List<BookReviewResponse>>> getBookReviewSortByStar(@RequestParam String sort) {
        List<BookReviewResponse> bookReviews = bookReviewService.getOrderByStar(sort);
        ResponseBody<List<BookReviewResponse>> responseBody = new ResponseBody<>(ResponseStatus.GET_BOOKREVIEW_LIST_SUCCESS, bookReviews);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(params = "sortBy=level")
    public ResponseEntity<ResponseBody<List<BookReviewResponse>>> getBookReviewSortByLevel(@RequestParam String sort) {
        List<BookReviewResponse> bookReviews = bookReviewService.getOrderByLevel(sort);
        ResponseBody<List<BookReviewResponse>> responseBody = new ResponseBody<>(ResponseStatus.GET_BOOKREVIEW_LIST_SUCCESS, bookReviews);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(params = "sortBy=createAt")
    public ResponseEntity<ResponseBody<List<BookReviewResponse>>> getBookReviewSortByCreateAt(@RequestParam String sort) {
        List<BookReviewResponse> bookReviews = bookReviewService.getOrderByCreateAt(sort);
        ResponseBody<List<BookReviewResponse>> responseBody = new ResponseBody<>(ResponseStatus.GET_BOOKREVIEW_LIST_SUCCESS, bookReviews);

        return ResponseEntity.ok(responseBody);
    }
}
