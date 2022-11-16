package com.cbu.backend.boardsubscribe.service;

import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.boardsubscribe.dto.request.BoardSubscribeRequest;
import com.cbu.backend.boardsubscribe.dto.response.BoardSubscribeResponse;
import com.cbu.backend.boardsubscribe.repository.BoardSubscribeRepository;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSubscribeService {

    private final BoardSubscribeRepository boardSubscribeRepository;

    private final BoardService boardService;
    private final MemberService memberService;

    public BoardSubscribeResponse subscribe(BoardSubscribeRequest dto) {
        throw new UnsupportedOperationException();
    }
}
