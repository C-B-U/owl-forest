package com.cbu.backend.bookReview.service;

import com.cbu.backend.bookReview.dto.request.CreateBookReviewRequestDTO;
import com.cbu.backend.bookReview.dto.response.BookReviewResponseDTO;
import com.cbu.backend.bookReview.entity.BookReview;
import com.cbu.backend.bookReview.mapper.BookReviewMapper;
import com.cbu.backend.bookReview.repository.BookReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReviewServiceImpl implements BookReviewService {

    private final BookReviewMapper bookReviewMapper;
    private final BookReviewRepository bookReviewRepository;

    /** 북리뷰 저장 */
    @Transactional
    @Override
    public void saveBookReview(CreateBookReviewRequestDTO createBookReviewRequestDTO) {

        BookReview bookReview = bookReviewMapper.mapToEntity(createBookReviewRequestDTO);
        bookReview.setCreateAt(LocalDateTime.now());
        bookReview.setUpdateAt(LocalDateTime.now());

        bookReviewRepository.save(bookReview);
    }

    /** 북리뷰 리스트 전체 조회 */
    @Transactional(readOnly = true)
    @Override
    public List<BookReviewResponseDTO> getBookReviewListAll() {

        List<BookReviewResponseDTO> bookReviewResponseDTOS = new ArrayList<>();
        List<BookReview> bookReviewList = bookReviewRepository.findAll();

        for (BookReview bookReview : bookReviewList) {
            BookReviewResponseDTO bookReviewResponseDTO = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponseDTOS.add(bookReviewResponseDTO);
        }

        return bookReviewResponseDTOS;
    }

    /** 북리뷰 한줄평 조회 */
    @Transactional(readOnly = true)
    @Override
    public List<BookReviewResponseDTO> getBookReviewBySimpleReview(String title) {

        List<BookReview> bookReviews = bookReviewRepository.findBookReviewBySimpleReviewContaining(title);
        List<BookReviewResponseDTO> bookReviewResponseDTOS = new ArrayList<>();

        for (BookReview bookReview : bookReviews) {
            BookReviewResponseDTO bookReviewResponseDTO = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponseDTOS.add(bookReviewResponseDTO);
        }

        return bookReviewResponseDTOS;
    }

    /** 북리뷰 상세 조회 */
    @Transactional(readOnly = true)
    @Override
    public BookReviewResponseDTO getBookReviewById(Long id) {

        BookReview bookReview = bookReviewRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("상세 리뷰가 존재하지 않습니다."));

        BookReviewResponseDTO bookReviewResponseDTO = bookReviewMapper.mapToDto(bookReview);

        return bookReviewResponseDTO;
    }

    /** 북리뷰 삭제 */
    @Override
    @Transactional
    public void deleteBookReview(Long id) {

        BookReview bookReview = bookReviewRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("삭제할 리뷰가 존재하지 않습니다."));

        bookReviewRepository.delete(bookReview);
    }
}
