package com.cbu.backend.boardcomment.controller;

import com.cbu.backend.boardcomment.dto.request.BoardCommentRequestDTO;
import com.cbu.backend.boardcomment.dto.response.BoardCommentResponseDTO;
import com.cbu.backend.boardcomment.service.BoardCommentService;
import com.cbu.backend.global.ResponseDTO;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board/{boardId}/comment")
public class BoardCommentController {
    private final BoardCommentService boardCommentService;


    @PostMapping
    public ResponseEntity<ResponseDTO<BoardCommentResponseDTO>> createComment(
            @PathVariable Long boardId,
            @RequestBody BoardCommentRequestDTO dto) {

        BoardCommentResponseDTO savedComment = boardCommentService.save(boardId, dto);
        ResponseDTO<BoardCommentResponseDTO> responseBody =
                new ResponseDTO<>(ResponseStatus.POST_BOARDCOMMENT_SUCCESS, savedComment);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<BoardCommentResponseDTO>>> getAllComment(
        @PathVariable Long boardId
    ) {
        List<BoardCommentResponseDTO> boardComments = boardCommentService.getAllByBoardId(boardId);
        ResponseDTO<List<BoardCommentResponseDTO>> responseBody =
                new ResponseDTO<>(ResponseStatus.GET_BOARDCOMMENT_LIST_SUCCESS, boardComments);

        return ResponseEntity.ok(responseBody);
    }
}
