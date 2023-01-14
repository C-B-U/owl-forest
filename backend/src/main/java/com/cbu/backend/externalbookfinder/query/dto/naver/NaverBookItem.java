package com.cbu.backend.externalbookfinder.query.dto.naver;

import com.cbu.backend.externalbookfinder.query.dto.ExternalBookResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NaverBookItem {
    private String title;
    private String link;
    private String image;
    private String author;
    private String publisher;
    private String discount;
    private String pubdate;
    private String isbn;
    private String description;

    public ExternalBookResponse mapTOExternalBookResponse() {
        return ExternalBookResponse.builder()
                .title(title)
                .author(author)
                .publisher(publisher)
                .publishAt(LocalDate.parse(pubdate, DateTimeFormatter.BASIC_ISO_DATE))
                .price(Integer.parseInt(discount))
                .imageUrl(image)
                .build();
    }
}
