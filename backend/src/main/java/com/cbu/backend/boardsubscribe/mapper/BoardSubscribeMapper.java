package com.cbu.backend.boardsubscribe.mapper;

import com.cbu.backend.board.entity.Board;
import com.cbu.backend.boardsubscribe.dto.response.BoardSubscribeResponse;
import com.cbu.backend.boardsubscribe.entity.BoardSubscribe;
import com.cbu.backend.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class BoardSubscribeMapper {

    public BoardSubscribe toEntity(Board board, Member member) {
        return BoardSubscribe.builder()
                .board(board)
                .member(member)
                .build();
    }

    public BoardSubscribeResponse toDto(BoardSubscribe entity) {
        // 응답 할게 없어...

        return BoardSubscribeResponse.builder().build();
    }
}
