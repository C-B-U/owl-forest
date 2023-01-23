package com.cbu.backend.externalbookfinder.query.api;

import com.cbu.backend.externalbookfinder.query.dto.BookFinderRequest;
import com.cbu.backend.externalbookfinder.query.dto.ExternalBookResponse;
import com.cbu.backend.externalbookfinder.query.service.BookSearchable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/externalbooks")
public class ExternalBookFinderController {
    private final BookSearchable searchBookService;

    @GetMapping
    public ResponseEntity<List<ExternalBookResponse>> getExternalBooks(
            @RequestBody @Valid BookFinderRequest req) {
        return ResponseEntity.ok(searchBookService.findAllBy(req));
    }
}
