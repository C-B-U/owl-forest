package com.cbu.backend.studyplan;

import com.cbu.backend.studyplan.dto.StudyPlanIdResponse;
import com.cbu.backend.studyplan.dto.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.StudyPlanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyPlanService {

    private final StudyPlanMapper studyPlanMapper;
    private final StudyPlanRepository studyPlanRepository;

    public StudyPlanIdResponse saveStudyPlan(StudyPlanRequest request) {
        Long id = studyPlanRepository.save(studyPlanMapper.toEntity(request)).getId();
        return new StudyPlanIdResponse(id);
    }

    @Transactional
    public void updateStudyPlan(Long id, StudyPlanRequest request) {
        getEntity(id).update(request.getTitle(),
                request.getStudyRule(),
                request.getWeekPlan());
    }

    @Transactional
    public void deleteStudyPlan(Long id) {
        getEntity(id).delete();
    }

    private StudyPlan getEntity(Long id) {
        return studyPlanRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public StudyPlanResponse findStudyPlan(Long id) {
        return studyPlanMapper.toResponse(getEntity(id));
    }
}
