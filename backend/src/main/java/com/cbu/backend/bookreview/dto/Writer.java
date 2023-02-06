package com.cbu.backend.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Writer {
    private UUID id;
    private String name;
}
