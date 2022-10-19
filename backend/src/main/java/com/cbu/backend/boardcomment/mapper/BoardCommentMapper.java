package com.cbu.backend.boardcomment.mapper;

import com.cbu.backend.board.entity.Board;
import com.cbu.backend.boardcomment.dto.request.BoardCommentRequestDTO;
import com.cbu.backend.boardcomment.dto.response.BoardCommentResponseDTO;
import com.cbu.backend.boardcomment.entity.BoardComment;
import org.springframework.stereotype.Component;

@Component
public class BoardCommentMapper {

    public BoardComment toEntity(BoardCommentRequestDTO dto, Board board) {

        return BoardComment.builder()
                .board(board)
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    public BoardCommentResponseDTO toDto(BoardComment entity) {

        return BoardCommentResponseDTO.builder()
               .id(entity.getId())
               .content(entity.getContent())
               .writer(entity.getWriter())
               .build();
    }
}