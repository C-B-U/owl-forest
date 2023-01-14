package com.cbu.backend.externalbookfinder.query.service;

import com.cbu.backend.externalbookfinder.query.dto.BookFinderRequest;
import com.cbu.backend.externalbookfinder.query.dto.ExternalBookResponse;

import java.util.List;

public interface BookSearchable {
    public List<ExternalBookResponse> findAllBy(BookFinderRequest req);
}
