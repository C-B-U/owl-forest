package com.cbu.backend.board.mapper;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.entity.BoardType;
import com.cbu.backend.global.Mapper;

@Mapper
public class BoardMapper {
    public Board toEntity(BoardRequestDTO dto) {
        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .boardType(BoardType.valueOf(dto.getBoardType()))
                .isPublic(dto.getIsPublic())
                .build();
    }

    public BoardResponseDTO toDto(Board entity) {
        return BoardResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .boardType(entity.getBoardType().name())
                .isPublic(entity.isPublic())
                .createdAt(entity.getBaseTime().getCreatedAt())
                .updatedAt(entity.getBaseTime().getUpdatedAt())
                .build();
    }
}
