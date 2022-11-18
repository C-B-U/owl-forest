package com.cbu.backend.bookreview.controller;

import com.cbu.backend.bookreview.dto.request.CreateBookReviewRequest;
import com.cbu.backend.bookreview.service.BookReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
//
@RestController
@RequestMapping("api/book-review")
@RequiredArgsConstructor
public class BookReviewController {
    private final BookReviewService bookReviewService;

    //북리뷰 등록
    @PostMapping
    public void create(@RequestBody CreateBookReviewRequest createBookReviewRequestDTO) {
        throw new UnsupportedOperationException("Not supported yet");
        //bookReviewService.createBookReview(createBookReviewRequestDTO);
    }

    //북리뷰 리스트 조회
    @GetMapping
    public void findAll() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    //북리뷰 한줄평으로 조회
    @GetMapping("description")
    public void findByDescription(@RequestParam String simpleReview) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    //북리뷰 필터 적용하여 조회
    @GetMapping("filter")
    public void findByFilter(@RequestParam Map<String, String> filter) {
        throw new UnsupportedOperationException("Not supported yet");

    }

    @GetMapping("{id}")
    public void findBookReviewDetail(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    //북리뷰 삭제
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
