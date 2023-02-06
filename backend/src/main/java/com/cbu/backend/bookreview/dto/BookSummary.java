package com.cbu.backend.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookSummary {
    private Long id;
    private String title;
    private String imageUrl;
}
