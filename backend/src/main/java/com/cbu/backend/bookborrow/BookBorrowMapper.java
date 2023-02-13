package com.cbu.backend.bookborrow;

import com.cbu.backend.bookborrow.dto.BookBorrowRequest;
import com.cbu.backend.bookborrow.dto.BookBorrowResponse;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookBorrowMapper {
    BookBorrow toEntity(BookBorrowRequest dto);

    BookBorrowResponse toResponse(BookBorrow entity);
}
