package com.cbu.backend.util;

import com.querydsl.core.types.OrderSpecifier;
import org.springframework.data.domain.Sort;

public interface OrderConverter {
    OrderSpecifier<?>[] convert(Sort sort);
}
