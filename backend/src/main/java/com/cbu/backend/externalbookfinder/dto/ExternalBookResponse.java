package com.cbu.backend.externalbookfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ExternalBookResponse {
    private final String title;
    private final String author;
    private final String publisher;
    private final String imageUrl;
    private final Integer price;
    private final LocalDate publishAt;
}
