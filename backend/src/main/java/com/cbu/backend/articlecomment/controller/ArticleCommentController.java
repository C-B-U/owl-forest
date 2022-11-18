package com.cbu.backend.articlecomment.controller;

import com.cbu.backend.articlecomment.dto.request.ArticleCommentRequest;
import com.cbu.backend.articlecomment.dto.response.ArticleCommentResponse;
import com.cbu.backend.articlecomment.service.ArticleCommentService;
import com.cbu.backend.global.ResponseFormat;
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
    public ResponseEntity<ResponseFormat<ArticleCommentResponse>> create(
            @PathVariable Long boardId,
            @RequestBody ArticleCommentRequest dto) {

        ArticleCommentResponse savedComment = articleCommentService.save(boardId, dto);
        ResponseFormat<ArticleCommentResponse> responseFormat =
                new ResponseFormat<>(ResponseStatus.POST_ARTICLECOMMENT_SUCCESS, savedComment);

        return ResponseEntity.ok(responseFormat);
    }
}
