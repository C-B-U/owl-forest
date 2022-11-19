package com.cbu.backend.bookreview.service;

import com.cbu.backend.bookreview.dto.request.CreateBookReviewRequest;
import com.cbu.backend.bookreview.dto.response.BookReviewResponse;

import java.util.List;

public interface BookReviewService {

    BookReviewResponse save(CreateBookReviewRequest createBookReviewRequest);
    BookReviewResponse deleteById(Long id);
    List<BookReviewResponse> getAll();
    List<BookReviewResponse> getAllByTitle(String title);
    BookReviewResponse getById(Long id);
    List<BookReviewResponse> getOrderByStar(String sort);
    List<BookReviewResponse> getOrderByLevel(String sort);
    List<BookReviewResponse> getOrderByCreateAt(String sort);

}
