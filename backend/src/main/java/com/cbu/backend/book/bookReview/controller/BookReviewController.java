package com.cbu.backend.bookReview.controller;

import com.cbu.backend.bookReview.dto.request.CreateBookReviewRequestDTO;
import com.cbu.backend.bookReview.service.BookReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bookReview")
public class BookReviewController {

    //북피뷰 등록
    @PostMapping
    public void enrollBookReview(@RequestBody CreateBookReviewRequestDTO createBookReviewRequestDTO) {
        BookReviewService bookReviewService = new BookReviewService();
        bookReviewService.createBookReview(createBookReviewRequestDTO);
    }

    //북리뷰 리스트 조회
    @GetMapping
    public void findBookReviewList() {
    }

    //북리뷰 한줄평으로 조회
    @GetMapping
    public void findBookReviewByTitle(@RequestParam String simpleReview) {
    }

    //북리뷰 필터 적용하여 조회
    @GetMapping("/bookReview")
    public void findBookReviewByFilter(@RequestParam Map<String, String> filter) {
    }

    //북리뷰 상세조회
    @GetMapping("/bookReview/{id}")
    public void findBookReviewDetail(@PathVariable String id) {
    }

    @DeleteMapping("/bookReview/{id}")
    public void deleteBookReview(@PathVariable String id) {
    }
}
