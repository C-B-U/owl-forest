package com.cbu.backend.board.controller;

import com.cbu.backend.board.dto.request.BoardRequest;
import com.cbu.backend.board.dto.request.UpdateBoardRequest;
import com.cbu.backend.board.dto.response.BoardResponse;
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
    public ResponseEntity<ResponseFormat<BoardResponse>> create(@RequestBody BoardRequest dto) {
        BoardResponse savedBoard = boardService.create(dto);
        ResponseFormat<BoardResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.POST_BOARD_SUCCESS, savedBoard);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseFormat);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseFormat<BoardResponse>> update(
            @PathVariable Long id, @RequestBody UpdateBoardRequest dto) {
        BoardResponse updatedBoard = boardService.updateById(id, dto);
        ResponseFormat<BoardResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.UPDATE_BOARD_SUCCESS, updatedBoard);

        return ResponseEntity.ok(responseFormat);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseFormat<BoardResponse>> delete(@PathVariable Long id) {
        BoardResponse deletedBoard = boardService.deleteById(id);
        ResponseFormat<BoardResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.DELETE_BOARD_SUCCESS, deletedBoard);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseFormat<BoardResponse>> findById(@PathVariable Long id) {
        BoardResponse board = boardService.findById(id);
        ResponseFormat<BoardResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.GET_BOARD_SUCCESS, board);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping
    public ResponseEntity<ResponseFormat<List<BoardResponse>>> getAll(Pageable pageable) {
        List<BoardResponse> boards = boardService.getAll(pageable);
        ResponseFormat<List<BoardResponse>> responseFormat =
                new ResponseFormat<>(ResponseStatus.GET_BOARD_LIST_SUCCESS, boards);

        return ResponseEntity.ok(responseFormat);
    }
}
