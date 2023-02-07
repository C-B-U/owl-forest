package com.cbu.backend.studyactivity;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudyActivityMapper {
    @Mapping(target = "studyParticipants", source = "studyParticipants")
    @Mapping(target = "description", source = "studyActivityRequest.description")
    StudyActivity toEntity(
            StudyActivityRequest studyActivityRequest, List<Member> studyParticipants);
    StudyActivityResponse toResponse(StudyActivity studyActivity);
}
