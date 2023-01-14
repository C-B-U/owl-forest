package com.cbu.backend.externalbookfinder.query.infra;

import com.cbu.backend.externalbookfinder.query.dto.BookFinderRequest;
import com.cbu.backend.externalbookfinder.query.dto.ExternalBookResponse;
import com.cbu.backend.externalbookfinder.query.dto.naver.NaverApiResponse;
import com.cbu.backend.externalbookfinder.query.service.BookSearchable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Component
public class NaverBookFinder implements BookSearchable {
    private static final String NAVER_CLIENT_ID_ENV_LOCATION = "${spring.security.oauth2.client.registration.naver.client-id}";
    private static final String NAVER_SECRET_KEY_ENV_LOCATION = "${spring.security.oauth2.client.registration.naver.client-secret}";
    private final WebClient naverBookFinderClient;

    public NaverBookFinder(@Value(NAVER_CLIENT_ID_ENV_LOCATION) String clientId,
                           @Value(NAVER_SECRET_KEY_ENV_LOCATION) String secretKey) {
        naverBookFinderClient = generateWebClient(clientId, secretKey);
    }

    private WebClient generateWebClient(String clientId, String secretKey) {
        return WebClient.builder()
                .baseUrl("https://openapi.naver.com/v1/search/book.json")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Naver-Client-Id", clientId)
                .defaultHeader("X-Naver-Client-Secret", secretKey)
                .build();
    }

    @Override
    public List<ExternalBookResponse> findAllBy(BookFinderRequest req) {
        NaverApiResponse apiResponse = requestToNaverClient(req)
                .orElseThrow(SearchResultNotExistException::new);

        return apiResponse.mapToExternalBookResponseList();
    }

    private Optional<NaverApiResponse> requestToNaverClient(BookFinderRequest req) {

        NaverApiResponse apiResponse = naverBookFinderClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", req.getKeyword())
                        .queryParam("start", req.getPage())
                        .queryParam("display", req.getPageSize())
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve()
                .bodyToMono(NaverApiResponse.class)
                .block();

        return Optional.ofNullable(apiResponse);
    }

}
