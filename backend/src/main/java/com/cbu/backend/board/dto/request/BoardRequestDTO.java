package com.cbu.backend.board.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String boardType;
    private Boolean isPublic;
}
