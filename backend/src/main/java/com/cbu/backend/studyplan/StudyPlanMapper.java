package com.cbu.backend.studyplan;

import com.cbu.backend.studyplan.dto.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.StudyPlanResponse;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudyPlanMapper {
    StudyPlan toEntity(StudyPlanRequest studyPlanRequest);

    StudyPlanResponse toResponse(StudyPlan studyPlan);
}
