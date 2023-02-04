package com.cbu.backend.studygroup.query.infra;

import com.cbu.backend.util.OrderConverter;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.cbu.backend.studygroup.command.domain.QStudyGroup.studyGroup;

@Component
public class StudyGroupOrderConverter implements OrderConverter {

    private final Map<String, ComparableExpressionBase<?>> keywordMap = new HashMap<>();

    public StudyGroupOrderConverter() {
        initializeMap();
    }

    private void initializeMap() {
        keywordMap.put("createdAt", studyGroup.baseTime.createdAt);
        keywordMap.put("likeCount", studyGroup.likeCount.memberIds.size());
    }

    @Override
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
