package com.cbu.backend.studygroup.command.converter;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;

import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class StudyGroupNoConverter implements Converter<String, StudyGroupNo> {
    @Override
    public StudyGroupNo convert(String source) {
        return new StudyGroupNo(UUID.fromString(source));
    }
}
