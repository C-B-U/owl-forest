package com.cbu.backend.article.controller;

import com.cbu.backend.article.dto.request.ArticleRequest;
import com.cbu.backend.article.dto.response.ArticleResponse;
import com.cbu.backend.article.service.ArticleService;
import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/{boardId}/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ResponseFormat<ArticleResponse>> create(
            @PathVariable Long boardId,
            @RequestBody ArticleRequest dto) {
        ArticleResponse savedArticle = articleService.create(boardId, dto);
        ResponseFormat<ArticleResponse> responseFormat = new ResponseFormat<>(ResponseStatus.POST_ARTICLE_SUCCESS, savedArticle);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping
    public ResponseEntity<ResponseFormat<List<ArticleResponse>>> findAllByBoardId(
            @PathVariable Long boardId,
            Pageable pageable
            ) {
        List<ArticleResponse> articles = articleService.findAllByBoardId(boardId, pageable);
        ResponseFormat<List<ArticleResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_ARTICLE_LIST_SUCCESS, articles);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping("{articleId}")
    public ResponseEntity<ResponseFormat<ArticleResponse>> findById(
            @PathVariable Long boardId,
            @PathVariable Long articleId) {

        // TODO boardId 필요없는데... api 설계가 맞는지 검토 필
        ArticleResponse article = articleService.findById(articleId);
        ResponseFormat<ArticleResponse> responseFormat = new ResponseFormat<>(ResponseStatus.GET_ARTICLE_SUCCESS, article);

        return ResponseEntity.ok(responseFormat);
    }

}
