package com.cbu.backend.book;

import com.cbu.backend.member.domain.Member;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "register", source = "member")
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookRequest dto, Member member);
}
