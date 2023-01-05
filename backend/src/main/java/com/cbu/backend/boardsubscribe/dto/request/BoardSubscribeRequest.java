package com.cbu.backend.boardsubscribe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardSubscribeRequest {
    private Long boardId;
    private Long memberId;
}
