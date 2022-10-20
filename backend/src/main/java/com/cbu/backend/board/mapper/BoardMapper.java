package com.cbu.backend.board.mapper;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Mapper
@RequiredArgsConstructor
public class BoardMapper {

    private final MemberMapper memberMapper;

    public Board toEntity(BoardRequestDTO dto, Member member) {
        return Board.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .manager(member)
                .build();
    }

    public BoardResponseDTO toDto(Board entity) {
        return BoardResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .manager(memberMapper.toDto(entity.getManager()))
                .createdAt(entity.getBaseTime().getCreatedAt())
                .updatedAt(entity.getBaseTime().getUpdatedAt())
                .build();
    }
}
