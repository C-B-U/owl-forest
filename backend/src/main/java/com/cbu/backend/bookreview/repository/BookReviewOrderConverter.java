package com.cbu.backend.bookreview.repository;

import static com.cbu.backend.bookreview.QBookReview.bookReview;

import com.cbu.backend.util.OrderConverter;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookReviewOrderConverter implements OrderConverter {
    private final Map<String, ComparableExpressionBase<?>> keywordMap = new HashMap<>();

    public BookReviewOrderConverter() {
        initializeMap();
    }

    private void initializeMap() {
        keywordMap.put("createdAt", bookReview.baseTime.createdAt);
        keywordMap.put("score", bookReview.score);
        keywordMap.put("likeCount", bookReview.likeCount);
    }

    public OrderSpecifier<?>[] convert(Sort sort) {
        return sort.stream()
                .map(
                        s -> {
                            ComparableExpressionBase<?> path = keywordMap.get(s.getProperty());
                            if (s.isAscending()) {
                                return path.asc();
                            }
                            return path.desc();
                        })
                .toArray(OrderSpecifier[]::new);
    }
}
