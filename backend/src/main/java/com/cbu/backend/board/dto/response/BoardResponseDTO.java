package com.cbu.backend.board.dto.response;

import com.cbu.backend.member.dto.response.MemberResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponseDTO {

    private Long id;
    private String name;
    private String description;
    private MemberResponseDTO manager;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
