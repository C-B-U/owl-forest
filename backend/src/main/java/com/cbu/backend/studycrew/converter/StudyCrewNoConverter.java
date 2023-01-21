package com.cbu.backend.studycrew.converter;

import com.cbu.backend.studycrew.command.domain.StudyCrewNo;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class StudyCrewNoConverter implements Converter<String, StudyCrewNo> {
    @Override
    public StudyCrewNo convert(String source) {
        return new StudyCrewNo(UUID.fromString(source));
    }
}