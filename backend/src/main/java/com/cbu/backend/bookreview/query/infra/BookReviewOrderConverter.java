package com.cbu.backend.bookreview.query.infra;

import com.cbu.backend.bookreview.command.domain.QBookReview;
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
    private final QBookReview qBookReview;

    public BookReviewOrderConverter(QBookReview qBookReview) {
        this.qBookReview = qBookReview;
        initializeMap();
    }

    private void initializeMap() {
        keywordMap.put("createdAt", qBookReview.baseTime.createdAt);
        keywordMap.put("score", qBookReview.score);
        keywordMap.put("likeCount", qBookReview.likeCount);
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
