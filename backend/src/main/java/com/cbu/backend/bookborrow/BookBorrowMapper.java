package com.cbu.backend.bookborrow;

import com.cbu.backend.book.Book;
import com.cbu.backend.bookborrow.dto.BookBorrowRequest;
import com.cbu.backend.bookborrow.dto.BookBorrowResponse;
import com.cbu.backend.member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookBorrowMapper {
    @Mapping(target = "book", source = "book")
    BookBorrow toEntity(BookBorrowRequest dto, Book book, Member writer);

    BookBorrowResponse toResponse(BookBorrow entity);
}
