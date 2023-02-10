package com.cbu.backend.externalbookfinder.dto.naver;

import com.cbu.backend.externalbookfinder.dto.ExternalBookResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NaverApiResponse {
    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<NaverBookItem> items;

    public List<ExternalBookResponse> mapToExternalBookResponseList() {
        return items.stream().map(NaverBookItem::mapTOExternalBookResponse).toList();
    }
}
