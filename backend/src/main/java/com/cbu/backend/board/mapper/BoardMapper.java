package com.cbu.backend.board.mapper;

import com.cbu.backend.board.dto.request.BoardRequest;
import com.cbu.backend.board.dto.response.BoardResponse;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardMapper {

    private final MemberMapper memberMapper;

    public Board toEntity(BoardRequest dto, Member member) {
        return Board.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .manager(member)
                .build();
    }

    public BoardResponse toDto(Board entity) {
        return BoardResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .manager(memberMapper.toDto(entity.getManager()))
                .createdAt(entity.getBaseTime().getCreatedAt())
                .updatedAt(entity.getBaseTime().getUpdatedAt())
                .build();
    }
}
