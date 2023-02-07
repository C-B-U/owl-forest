package com.cbu.backend.book;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthService authService;

    @Transactional
    public Book saveIfNotExists(BookRequest req) {
        return bookRepository.findByIsbn(req.getIsbn()).orElseGet(() -> bookRepository.save(saveBook(req)));
    }

    private Book saveBook(BookRequest req) {
        Member register = authService.getLoginUser();
        return bookMapper.toEntity(req, register);
    }
}
