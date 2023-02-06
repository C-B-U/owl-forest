package com.cbu.backend.book;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.domain.Member;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {
    @Mapping(target = "register", source="member")
    Book toEntity(BookRequest dto, Member member);
}
