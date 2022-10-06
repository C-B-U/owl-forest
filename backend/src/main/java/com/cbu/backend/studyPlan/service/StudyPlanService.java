package com.cbu.backend.studyPlan.service;

import com.cbu.backend.studyPlan.dto.request.StudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.response.StudyPlanResponseDTO;
import com.cbu.backend.studyPlan.entity.StudyPlan;
import com.cbu.backend.studyPlan.repository.StudyPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyPlanService {

    private final StudyPlanRepository studyPlanRepository;

    public StudyPlanResponseDTO create(StudyPlanRequestDTO dto, Long studyGroupId) {
        studyPlanRepository.save(dto.toEntity());
    }

    public StudyPlanResponseDTO update(StudyPlanRequestDTO dto, Long studyPlanId){
        Optional<StudyPlan> update = studyPlanRepository.findById(studyPlanId);
        StudyPlan studyPlan = (StudyPlan) dto.toEntity();
        if(update.isPresent()){
            if(studyPlan != null){
                update.get().
            }
        }
    }

    public void delete(StudyPlanRequestDTO dto){
        studyPlanRepository.delete(dto.toEntity());
    }
}
