package com.cbu.backend.bookreview.service;

import com.cbu.backend.book.entity.Book;
import com.cbu.backend.book.service.BookService;
import com.cbu.backend.bookreview.dto.request.CreateBookReviewRequest;
import com.cbu.backend.bookreview.dto.response.BookReviewResponse;
import com.cbu.backend.bookreview.entity.BookReview;
import com.cbu.backend.bookreview.mapper.BookReviewMapper;
import com.cbu.backend.bookreview.repository.BookReviewRepository;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookReviewServiceImpl implements BookReviewService {
    private final BookReviewMapper bookReviewMapper;
    private final BookReviewRepository bookReviewRepository;
    private final BookService bookService;
    private final MemberService memberService;

    /** 북리뷰 저장 */
    @Transactional
    @Override
    public BookReviewResponse save(CreateBookReviewRequest dto) {
        Book book = bookService.getEntity(dto.getBookId());
        Member writer = memberService.getEntity(dto.getWriterId());
        BookReview bookReview = bookReviewMapper.mapToEntity(dto, book, writer);
        BookReview savedBookReview = bookReviewRepository.save(bookReview);

        return bookReviewMapper.mapToDto(savedBookReview);
    }

    /** 북리뷰 삭제 */
    @Transactional
    @Override
    public BookReviewResponse deleteById(Long id) {
        BookReview bookReview = getEntity(id);
        bookReviewRepository.delete(bookReview);

        return bookReviewMapper.mapToDto(bookReview);
    }

    public BookReview getEntity(Long id) {
        return bookReviewRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    /** 북리뷰 리스트 전체 조회 */
    @Override
    public List<BookReviewResponse> getAll() {

        List<BookReviewResponse> bookReviewResponses = new ArrayList<>();
        List<BookReview> bookReviewList = bookReviewRepository.findAll();

        for (BookReview bookReview : bookReviewList) {
            BookReviewResponse bookReviewResponse = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponses.add(bookReviewResponse);
        }

        return bookReviewResponses;
    }

    /** 북리뷰 한줄평 조회 */
    @Override
    public List<BookReviewResponse> getAllByTitle(String title) {

        List<BookReview> bookReviews = bookReviewRepository.findAllByTitleContaining(title);
        List<BookReviewResponse> bookReviewResponses = new ArrayList<>();

        for (BookReview bookReview : bookReviews) {
            BookReviewResponse bookReviewResponse = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponses.add(bookReviewResponse);
        }

        return bookReviewResponses;
    }

    /** 북리뷰 상세 조회 */
    @Override
    public BookReviewResponse getById(Long id) {
        BookReview bookReview = getEntity(id);

        return bookReviewMapper.mapToDto(bookReview);
    }

    /** 북리뷰 정렬 조회 : star*/
    @Override
    public List<BookReviewResponse> getOrderByStar(String sort) {

        List<BookReviewResponse> bookReviewResponses = new ArrayList<>();
        List<BookReview> bookReviewList = bookReviewRepository.findAllByOrderByStarDesc();

        for (BookReview bookReview : bookReviewList) {
            BookReviewResponse bookReviewResponseDTO = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponses.add(bookReviewResponseDTO);
        }

        if (sort == "asc") {
            Collections.reverse(bookReviewResponses);
        }

        return bookReviewResponses;
    }

    /** 북리뷰 정렬 조회 : level*/
    @Override
    public List<BookReviewResponse> getOrderByLevel(String sort) {

        List<BookReviewResponse> bookReviewResponses = new ArrayList<>();
        List<BookReview> bookReviewList = bookReviewRepository.findAllByOrderByLevelDesc();

        for (BookReview bookReview : bookReviewList) {
            BookReviewResponse bookReviewResponseDTO = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponses.add(bookReviewResponseDTO);
        }

        if (sort == "asc") {
            Collections.reverse(bookReviewResponses);
        }

        return bookReviewResponses;
    }

    /** 북리뷰 정렬 조회 : createAt*/
    @Override
    public List<BookReviewResponse> getOrderByCreateAt(String sort) {

        List<BookReviewResponse> bookReviewResponses = new ArrayList<>();
        List<BookReview> bookReviewList = bookReviewRepository.findAllByOrderByCreateAtDesc();

        for (BookReview bookReview : bookReviewList) {
            BookReviewResponse bookReviewResponseDTO = bookReviewMapper.mapToDto(bookReview);
            bookReviewResponses.add(bookReviewResponseDTO);
        }

        if (sort == "asc") {
            Collections.reverse(bookReviewResponses);
        }

        return bookReviewResponses;
    }
}
