package com.cbu.backend.studyplan.mapper;

import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.entity.StudyPlan;
import org.springframework.stereotype.Component;

@Component
public class StudyPlanMapper {

    public StudyPlan mapToEntity(StudyPlanRequest dto){
        return StudyPlan.builder()
                .title(dto.getTitle())
                .generationNum(dto.getGenerationNum())
                .rule(dto.getRule())
                .teamMember(dto.getTeamMember())
                .book(dto.getBook())
                .studyGroupId(dto.getStudyGroupId())
                .build();
    }

    public StudyPlanResponse mapToDTO(StudyPlan entity){
        return StudyPlanResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .generationNum(entity.getGenerationNum())
                .rule(entity.getRule())
                .teamMember(entity.getTeamMember())
                .book(entity.getBook())
                .studyGroupId(entity.getStudyGroupId())
                .build();
    }
}
