package com.cbu.backend.studyPlan.mapper;

import com.cbu.backend.studyPlan.dto.request.StudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.response.StudyPlanResponseDTO;
import com.cbu.backend.studyPlan.entity.StudyPlan;
import org.springframework.stereotype.Component;

@Component
public class StudyPlanMapper {

    public StudyPlan mapToEntity(StudyPlanRequestDTO dto){
        return StudyPlan.builder()
                .title(dto.getTitle())
                .generationNum(dto.getGenerationNum())
                .rule(dto.getRule())
                .teamMember(dto.getTeamMember())
                .book(dto.getBook())
                .build();
    }

    public StudyPlanResponseDTO mapToDTO(StudyPlan entity){
        return StudyPlanResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .generationNum(entity.getGenerationNum())
                .rule(entity.getRule())
                .teamMember(entity.getTeamMember())
                .book(entity.getBook())
                .build();

    }
}
