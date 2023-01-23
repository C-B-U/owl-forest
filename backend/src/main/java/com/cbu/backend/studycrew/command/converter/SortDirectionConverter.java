package com.cbu.backend.studycrew.command.converter;

import com.cbu.backend.studycrew.command.domain.SortDirection;

import org.springframework.core.convert.converter.Converter;

public class SortDirectionConverter implements Converter<String, SortDirection> {
    @Override
    public SortDirection convert(String source) {
        return SortDirection.valueOf(source.toUpperCase());
    }
}
