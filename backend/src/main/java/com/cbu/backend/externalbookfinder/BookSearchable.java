package com.cbu.backend.externalbookfinder;

import com.cbu.backend.externalbookfinder.dto.BookFinderRequest;
import com.cbu.backend.externalbookfinder.dto.ExternalBookResponse;

import java.util.List;

public interface BookSearchable {
    public List<ExternalBookResponse> findAllBy(BookFinderRequest req);
}
