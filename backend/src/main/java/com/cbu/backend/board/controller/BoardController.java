package com.cbu.backend.board.controller;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.request.UpdateBoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<ResponseFormat<BoardResponseDTO>> createBoard(@RequestBody BoardRequestDTO dto) {
        BoardResponseDTO savedBoard = boardService.save(dto);
        ResponseFormat<BoardResponseDTO> responseFormat = new ResponseFormat<>(ResponseStatus.POST_BOARD_SUCCESS, savedBoard);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseFormat<BoardResponseDTO>> updateBoard(
            @PathVariable Long id,
            @RequestBody UpdateBoardRequestDTO dto) {
        BoardResponseDTO updatedBoard = boardService.update(id, dto);
        ResponseFormat<BoardResponseDTO> responseFormat = new ResponseFormat<>(ResponseStatus.UPDATE_BOARD_SUCCESS, updatedBoard);

        return ResponseEntity.ok(responseFormat);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseFormat<BoardResponseDTO>> deleteBoard(@PathVariable Long id) {
        BoardResponseDTO deletedBoard = boardService.delete(id);
        ResponseFormat<BoardResponseDTO> responseFormat = new ResponseFormat<>(ResponseStatus.DELETE_BOARD_SUCCESS, deletedBoard);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseFormat<BoardResponseDTO>> getBoard(@PathVariable Long id) {
        BoardResponseDTO board = boardService.get(id);
        ResponseFormat<BoardResponseDTO> responseFormat = new ResponseFormat<>(ResponseStatus.GET_BOARD_SUCCESS, board);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping
    public ResponseEntity<ResponseFormat<List<BoardResponseDTO>>> getAllBoard(Pageable pageable) {
        List<BoardResponseDTO> boards = boardService.getAll(pageable);
        ResponseFormat< List<BoardResponseDTO>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_BOARD_LIST_SUCCESS, boards);

        return ResponseEntity.ok(responseFormat);
    }
}
