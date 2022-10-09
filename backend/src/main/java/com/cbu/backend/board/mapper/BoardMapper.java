package com.cbu.backend.board.mapper;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.global.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper
public class BoardMapper {
    public Board toEntity(BoardRequestDTO bto) {
        throw new UnsupportedOperationException();
    }  
}
