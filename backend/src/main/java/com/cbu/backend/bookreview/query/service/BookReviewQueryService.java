package com.cbu.backend.bookreview.query.service;

import com.cbu.backend.bookreview.query.infra.BookReviewDao;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookReviewQueryService {
    private final BookReviewMapper bookReviewMapper;
    private final BookReviewDao bookReviewDao;
}
