package com.cbu.backend.book;

import com.cbu.backend.member.MemberService;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.util.AuthUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MemberService memberService;
    private final BookMapper bookMapper;

    public Book saveIfNotExists(BookRequest req) {
        return bookRepository.findByIsbn(req.getIsbn()).orElseGet(() -> saveBook(req));
    }

    private Book saveBook(BookRequest req) {
        Member register = AuthUtils.getLoginUser();
        return bookMapper.toEntity(req, register);
    }
}
