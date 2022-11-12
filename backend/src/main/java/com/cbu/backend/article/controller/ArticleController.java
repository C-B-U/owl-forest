package com.cbu.backend.article.controller;

import com.cbu.backend.article.dto.request.ArticleRequestDTO;
import com.cbu.backend.article.dto.response.ArticleResponseDTO;
import com.cbu.backend.article.service.ArticleService;
import com.cbu.backend.global.ResponseBody;
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
    public ResponseEntity<ResponseBody<ArticleResponseDTO>> createArticle(
            @PathVariable Long boardId,
            @RequestBody ArticleRequestDTO dto) {
        ArticleResponseDTO savedArticle = articleService.save(boardId, dto);
        ResponseBody<ArticleResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.POST_ARTICLE_SUCCESS, savedArticle);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<ResponseBody<List<ArticleResponseDTO>>> getAllByBoardId(
            @PathVariable Long boardId,
            Pageable pageable
            ) {
        List<ArticleResponseDTO> articles = articleService.getAllByBoardId(boardId, pageable);
        ResponseBody<List<ArticleResponseDTO>> responseBody = new ResponseBody<>(ResponseStatus.GET_ARTICLE_LIST_SUCCESS, articles);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("{articleId}")
    public ResponseEntity<ResponseBody<ArticleResponseDTO>> getArticle(
            @PathVariable Long boardId,
            @PathVariable Long articleId) {

        // TODO boardId 필요없는데... api 설계가 맞는지 검토 필
        ArticleResponseDTO article = articleService.get(articleId);
        ResponseBody<ArticleResponseDTO> responseBody = new ResponseBody<>(ResponseStatus.GET_ARTICLE_SUCCESS, article);

        return ResponseEntity.ok(responseBody);
    }

}
