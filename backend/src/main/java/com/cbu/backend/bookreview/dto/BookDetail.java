package com.cbu.backend.bookreview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDetail {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String imageUrl;
}
