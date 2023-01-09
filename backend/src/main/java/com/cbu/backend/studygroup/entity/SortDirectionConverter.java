package com.cbu.backend.studygroup.entity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 정렬 방향(DESC, ASC)을 컨트롤러에서 받아올 수 있도록 변환해주는 클래스
 *
 * @author ohksj(김승진)
 */
@Component
public class SortDirectionConverter implements Converter<String, SortDirection> {

    @Override
    public SortDirection convert(String source) {
        return SortDirection.valueOf(source.toUpperCase());
    }
}
