package com.cbu.backend.mapper;

import com.cbu.backend.dto.ReplyRequest;
import com.cbu.backend.dto.ReplyResponse;
import com.cbu.backend.entity.Reply;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public Reply mapToEntity(ReplyRequest dto){
        return Reply.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .build();
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
