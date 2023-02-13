package com.cbu.backend.bookborrow;

import com.cbu.backend.bookborrow.dto.BookBorrowRequest;
import com.cbu.backend.bookborrow.dto.BookBorrowResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookBorrowService {
    private final BookBorrowRepository bookBorrowRepository;
    private final BookBorrowMapper bookBorrowMapper;

    @Transactional
    public BookBorrowResponse create(BookBorrowRequest dto) {
        BookBorrow bookBorrow = bookBorrowRepository.save(bookBorrowMapper.toEntity(dto));
        return bookBorrowMapper.toResponse(bookBorrow);
    }

    public List<BookBorrowResponse> findAll(Pageable pageable) {
        return bookBorrowRepository.findAll(pageable).stream()
                .map(bookBorrowMapper::toResponse)
                .toList();
    }

    public List<BookBorrowResponse> findAllByBookName(String bookName) {
        return bookBorrowRepository.findAllByBookTitleContaining(bookName).stream()
                .map(bookBorrowMapper::toResponse)
                .toList();
    }
}
