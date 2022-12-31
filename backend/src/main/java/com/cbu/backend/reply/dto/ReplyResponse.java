package com.cbu.backend.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ReplyResponse {
  private Long id;
  private String name;
  private String content;
  private String date;
}
