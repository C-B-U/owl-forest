package com.cbu.backend.board.dto.response;

import com.cbu.backend.member.dto.response.MemberResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponse {

    private Long id;
    private String name;
    private String description;
    private MemberResponse manager;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
