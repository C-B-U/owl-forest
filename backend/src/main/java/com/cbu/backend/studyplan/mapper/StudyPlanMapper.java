package com.cbu.backend.studyplan.mapper;

import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.entity.StudyPlan;
import org.springframework.stereotype.Component;

@Component
public class StudyPlanMapper {

    public StudyPlan mapToEntity(StudyPlanRequest dto){
        return StudyPlan.builder()
                .rule(dto.getRule())
                .book(dto.getBook())
                .build();
    }

    public StudyPlanResponse mapToDTO(StudyPlan entity){
        return StudyPlanResponse.builder()
                .id(entity.getId())
                .rule(entity.getRule())
                .book(entity.getBook())
                .build();
    }
}
