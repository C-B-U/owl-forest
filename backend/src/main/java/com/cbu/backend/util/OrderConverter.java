package com.cbu.backend.util;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.data.domain.Sort;

public class OrderConverter {
    public static OrderSpecifier[] convert(Sort sort, Class<?> type, String metadata) {
        PathBuilder pathBuilder = new PathBuilder(type, metadata);

        return sort.stream().map(s -> {
            Order order = s.isAscending() ? Order.ASC : Order.DESC;
            return new OrderSpecifier(order, pathBuilder.get(s.getProperty()));
        }).toArray(OrderSpecifier[]::new);
    }
}
