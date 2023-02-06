package com.cbu.backend.book;

import com.cbu.backend.member.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MemberService memberService;

    public Book saveIfNotExists(BookRequest req) {
        return bookRepository.findByIsbn(req.getIsbn()).orElseGet(() -> saveBook(req));
    }

    private Book saveBook(BookRequest req) {
        return bookRepository.save(
                Book.builder()
                        .title(req.getTitle())
                        .isbn(req.getIsbn())
                        .author(req.getAuthor())
                        .imageUrl(req.getImageUrl())
                        .price(req.getPrice())
                        .publishAt(req.getPublishAt())
                        .publisher(req.getPublisher())
                        .register(memberService.findById(req.getRegistrant()))
                        .build());
    }
}
