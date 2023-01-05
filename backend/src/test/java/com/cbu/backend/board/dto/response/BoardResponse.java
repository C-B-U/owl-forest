package com.cbu.backend.board.dto.response;

import com.cbu.backend.member.dto.response.MemberResponse;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
