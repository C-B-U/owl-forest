package com.cbu.backend.reply.mapper;

import com.cbu.backend.reply.dto.ReplyRequest;
import com.cbu.backend.reply.dto.ReplyResponse;
import com.cbu.backend.reply.entity.Reply;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
  public Reply mapToEntity(ReplyRequest dto) {
    return Reply.builder().name(dto.getName()).content(dto.getContent()).build();
  }

  public ReplyResponse mapToDTO(Reply entity) {
    return ReplyResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .content(entity.getContent())
        .date(entity.getDate())
        .build();
  }
}
