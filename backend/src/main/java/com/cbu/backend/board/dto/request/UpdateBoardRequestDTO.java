package com.cbu.backend.board.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBoardRequestDTO {

    private String title;
    private String content;
    private Boolean isPublic;

}
