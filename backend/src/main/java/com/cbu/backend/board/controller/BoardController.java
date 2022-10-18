package com.cbu.backend.board.controller;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.request.UpdateBoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.global.ResponseDTO;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<ResponseDTO<BoardResponseDTO>> createBoard(@RequestBody BoardRequestDTO dto) {
        BoardResponseDTO savedBoard = boardService.save(dto);
        ResponseDTO<BoardResponseDTO> responseBody = new ResponseDTO<>(ResponseStatus.POST_BOARD_SUCCESS, savedBoard);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseDTO<BoardResponseDTO>> updateBoard(
            @PathVariable Long id,
            @RequestBody UpdateBoardRequestDTO dto) {
        BoardResponseDTO updatedBoard = boardService.update(id, dto);
        ResponseDTO<BoardResponseDTO> responseBody = new ResponseDTO<>(ResponseStatus.UPDATE_BOARD_SUCCESS, updatedBoard);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO<BoardResponseDTO>> deleteBoard(@PathVariable Long id) {
        BoardResponseDTO deletedBoard = boardService.delete(id);
        ResponseDTO<BoardResponseDTO> responseBody = new ResponseDTO<>(ResponseStatus.DELETE_BOARD_SUCCESS, deletedBoard);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO<BoardResponseDTO>> getBoard(@PathVariable Long id) {
        BoardResponseDTO board = boardService.get(id);
        ResponseDTO<BoardResponseDTO> responseBody = new ResponseDTO<>(ResponseStatus.GET_BOARD_SUCCESS, board);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<BoardResponseDTO>>> getAllBoard() {
        List<BoardResponseDTO> board = boardService.getAll();
        ResponseDTO< List<BoardResponseDTO>> responseBody = new ResponseDTO<>(ResponseStatus.GET_BOARD_LIST_SUCCESS, board);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
