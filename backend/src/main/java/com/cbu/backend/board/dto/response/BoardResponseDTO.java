package com.cbu.backend.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponseDTO {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private String boardType;

    private Boolean isPublic;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
