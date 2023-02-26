package com.cbu.backend.bookborrow;

import com.cbu.backend.book.Book;
import com.cbu.backend.book.BookService;
import com.cbu.backend.bookborrow.dto.BookBorrowRequest;
import com.cbu.backend.bookborrow.dto.BookBorrowResponse;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BookBorrowService {
    private final BookBorrowRepository bookBorrowRepository;
    private final BookService bookService;
    private final AuthService authService;
    private final BookBorrowMapper bookBorrowMapper;

    @Transactional
    public BookBorrowResponse create(BookBorrowRequest dto) {
        Member loginUser = authService.getLoginUser();
        Book book = bookService.saveIfNotExists(dto.getBook());
        BookBorrow bookBorrow =
                bookBorrowRepository.save(bookBorrowMapper.toEntity(dto, book, loginUser));
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

    public List<BookBorrowResponse> findAllMyBorrow() {
        Member loginUser = authService.getLoginUser();
        return bookBorrowRepository.findAllByBorrower(loginUser).stream()
                .map(bookBorrowMapper::toResponse)
                .toList();
    }

    public List<BookBorrowResponse> findAllMyLend() {
        Member loginUser = authService.getLoginUser();
        return bookBorrowRepository.findAllByLender(loginUser).stream()
                .map(bookBorrowMapper::toResponse)
                .toList();
    }

    @Transactional
    public void borrow(Long id) {
        Member loginUser = authService.getLoginUser();
        getEntity(id).borrow(loginUser);
    }

    @Transactional
    public void returnBook(Long id) {
        getEntity(id).returnBook();
    }

    private BookBorrow getEntity(Long id) {
        return bookBorrowRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
