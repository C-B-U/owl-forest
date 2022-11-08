package com.cbu.backend.articlecomment.controller;

import com.cbu.backend.articlecomment.dto.request.ArticleCommentRequestDTO;
import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponseDTO;
import com.cbu.backend.articlecomment.service.ArticleCommentService;
import com.cbu.backend.global.ResponseBody;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board/{boardId}/comment")
public class ArticleCommentController {
    private final ArticleCommentService articleCommentService;


    @PostMapping
    public ResponseEntity<ResponseBody<ArticleCommentResponseDTO>> createComment(
            @PathVariable Long boardId,
            @RequestBody ArticleCommentRequestDTO dto) {

        ArticleCommentResponseDTO savedComment = articleCommentService.save(boardId, dto);
        ResponseBody<ArticleCommentResponseDTO> responseBody =
                new ResponseBody<>(ResponseStatus.POST_ARTICLECOMMENT_SUCCESS, savedComment);

        return ResponseEntity.ok(responseBody);
    }
}
