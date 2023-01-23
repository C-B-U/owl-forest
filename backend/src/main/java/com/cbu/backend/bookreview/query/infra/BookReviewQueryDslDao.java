package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.bookreview.command.domain.BookReviewNo;
import com.cbu.backend.bookreview.query.dto.BookReviewResponse;
import com.cbu.backend.bookreview.query.dto.BookReviewSummaryResponse;

import java.util.List;
import java.util.Optional;

public interface BookReviewQueryDslDao {
    List<BookReviewSummaryResponse> findSummaryAll();
    Optional<BookReviewResponse> findResponseById(BookReviewNo id);
}
