package com.cbu.backend.config.converter;

import com.cbu.backend.studycrew.converter.SortDirectionConverter;
import com.cbu.backend.studycrew.converter.StudyCrewNoConverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StudyCrewNoConverter());
        registry.addConverter(new SortDirectionConverter());
    }
}
