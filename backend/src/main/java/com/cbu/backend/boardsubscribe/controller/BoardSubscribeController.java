package com.cbu.backend.boardsubscribe.controller;

import com.cbu.backend.boardsubscribe.dto.request.BoardSubscribeRequest;
import com.cbu.backend.boardsubscribe.dto.response.BoardSubscribeResponse;
import com.cbu.backend.boardsubscribe.service.BoardSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/boardSubscribe")
@RequiredArgsConstructor
public class BoardSubscribeController {
    private final BoardSubscribeService boardSubscribeService;

    @PostMapping
    public ResponseEntity<BoardSubscribeResponse> subscribe(@RequestBody BoardSubscribeRequest dto) {
        boardSubscribeService.subscribe(dto);

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
