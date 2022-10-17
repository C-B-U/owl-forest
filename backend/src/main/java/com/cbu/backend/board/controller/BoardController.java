package com.cbu.backend.board.controller;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.global.ResponseConvertor;
import com.cbu.backend.global.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardController {
    private final BoardService boardService;

    private final ResponseConvertor responseConvertor;

    @PostMapping
    public ResponseEntity<ResponseFormat<BoardResponseDTO>> createBoard(@RequestBody BoardRequestDTO dto) {
        BoardResponseDTO result = boardService.save(dto);

        return responseConvertor
                .to(new ResponseFormat<BoardResponseDTO>(HttpStatus.CREATED,result));
    }
}
