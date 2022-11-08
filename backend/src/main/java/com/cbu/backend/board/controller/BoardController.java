package com.cbu.backend.board.controller;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.request.UpdateBoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.global.ResponseBody;
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
    public ResponseEntity<ResponseBody<BoardResponseDTO>> createBoard(@RequestBody BoardRequestDTO dto) {
        BoardResponseDTO savedBoard = boardService.save(dto);
        ResponseBody<BoardResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.POST_BOARD_SUCCESS, savedBoard);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseBody<BoardResponseDTO>> updateBoard(
            @PathVariable Long id,
            @RequestBody UpdateBoardRequestDTO dto) {
        BoardResponseDTO updatedBoard = boardService.update(id, dto);
        ResponseBody<BoardResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.UPDATE_BOARD_SUCCESS, updatedBoard);

        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseBody<BoardResponseDTO>> deleteBoard(@PathVariable Long id) {
        BoardResponseDTO deletedBoard = boardService.delete(id);
        ResponseBody<BoardResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.DELETE_BOARD_SUCCESS, deletedBoard);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseBody<BoardResponseDTO>> getBoard(@PathVariable Long id) {
        BoardResponseDTO board = boardService.get(id);
        ResponseBody<BoardResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.GET_BOARD_SUCCESS, board);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseBody<List<BoardResponseDTO>>> getAllBoard(Pageable pageable) {
        List<BoardResponseDTO> boards = boardService.getAll(pageable);
        ResponseBody< List<BoardResponseDTO>> responseBody = new ResponseBody<>(ResponseStatus.GET_BOARD_LIST_SUCCESS, boards);

        return ResponseEntity.ok(responseBody);
    }
}
