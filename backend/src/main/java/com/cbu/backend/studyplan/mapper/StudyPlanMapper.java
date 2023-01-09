package com.cbu.backend.studyplan.mapper;

import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.request.WeekPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.dto.response.WeekPlanResponse;
import com.cbu.backend.studyplan.entity.StudyPlan;
import com.cbu.backend.studyplan.entity.WeekPlan;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 스터디 계획서 엔티티와 DTO 간의 변환을 수행하는 Mapper
 *
 * @author ohksj77(김승진)
 */
@Component
public class StudyPlanMapper {

    public StudyPlan toEntity(StudyPlanRequest dto, StudyGroup studyGroup) {
        StudyPlan studyPlan =
                StudyPlan.builder()
                        .title(dto.getTitle())
                        .generation(dto.getGeneration())
                        .rule(dto.getRule())
                        .studyGroup(studyGroup)
                        .build();
        registerWeekPlan(dto, studyPlan);

        return studyPlan;
    }

    private void registerWeekPlan(StudyPlanRequest dto, StudyPlan studyPlan) {
        toWeekPlanList(dto.getWeekPlans()).stream()
                .forEach(weekPlan -> weekPlan.registerWeekPlan(studyPlan));
    }

    private List<WeekPlan> toWeekPlanList(List<WeekPlanRequest> dtoList) {
        return dtoList.stream().map(this::toWeekPlan).collect(Collectors.toList());
    }

    private WeekPlan toWeekPlan(WeekPlanRequest dto) {
        return WeekPlan.builder()
                .studyDate(dto.getStudyDate())
                .week(dto.getWeek())
                .contents(dto.getContents())
                .build();
    }

    public StudyPlanResponse toResponse(StudyPlan entity) {
        return StudyPlanResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .generation(entity.getGeneration())
                .rule(entity.getRule())
                .studyGroupId(entity.getStudyGroup().getId())
                .weekPlans(toWeekPlanResponseList(entity.getWeekPlans()))
                .build();
    }

    private WeekPlanResponse toWeekPlanResponse(WeekPlan entity) {
        return WeekPlanResponse.builder()
                .id(entity.getId())
                .week(entity.getWeek())
                .studyDate(entity.getStudyDate())
                .contents(entity.getContents())
                .build();
    }

    private List<WeekPlanResponse> toWeekPlanResponseList(List<WeekPlan> entityList) {
        return entityList.stream().map(this::toWeekPlanResponse).collect(Collectors.toList());
    }
}
