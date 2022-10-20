package com.cbu.backend.boardsubscribe.controller;

import com.cbu.backend.boardsubscribe.service.BoardSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/boardSubscribe")
@RequiredArgsConstructor
public class BoardSubscribeController {
    private final BoardSubscribeService boardSubscribeService;

    @PostMapping
    public String subscribe() {
        boardSubscribeService.subscribe();
    }
}
