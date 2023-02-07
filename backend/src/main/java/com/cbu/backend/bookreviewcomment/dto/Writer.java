package com.cbu.backend.bookreviewcomment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
public class Writer {
    private UUID uuid;
    private String name;
}
