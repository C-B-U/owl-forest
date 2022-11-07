package com.cbu.backend.bookReview.service;

import com.cbu.backend.bookReview.dto.request.CreateBookReviewRequestDTO;
import com.cbu.backend.bookReview.dto.response.BookReviewResponseDTO;

import java.util.List;

public interface BookReviewService {

    void saveBookReview(CreateBookReviewRequestDTO createBookReviewRequestDTO) throws Exception;
    List<BookReviewResponseDTO> getBookReviewListAll() throws Exception;
    List<BookReviewResponseDTO> getBookReviewBySimpleReview(String title) throws Exception;
    BookReviewResponseDTO getBookReviewById(Long id) throws Exception;
    void deleteBookReview(Long id) throws Exception;

}
