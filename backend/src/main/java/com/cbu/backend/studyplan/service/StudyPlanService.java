package com.cbu.backend.studyplan.service;

import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.request.UpdateStudyPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.entity.StudyPlan;
import com.cbu.backend.studyplan.mapper.StudyPlanMapper;
import com.cbu.backend.studyplan.repository.StudyPlanRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyPlanService {

  private final StudyPlanRepository studyPlanRepository;
  private final StudyPlanMapper studyPlanMapper;

  // 스터디 계획서 생성
  @Transactional
  public StudyPlanResponse create(StudyPlanRequest requestDto, Long studyGroupId) {
    StudyPlan studyPlan = studyPlanMapper.mapToEntity(requestDto);
    studyPlanRepository.save(studyPlan);

    return studyPlanMapper.mapToDTO(studyPlan);
  }

  @Transactional
  // 스터디 계획서 수정 (미완)
  public StudyPlanResponse update(UpdateStudyPlanRequest dto, Long studyPlanId) {
    //        Optional<StudyPlan> update = studyPlanRepository.findById(studyPlanId);
    //        StudyPlan studyPlan = studyPlanMapper.mapToEntity(dto);
    StudyPlan studyPlan = getEntity(studyPlanId);
    changeStudyPlan(studyPlan, dto);

    return studyPlanMapper.mapToDTO(studyPlan);
  }

  private void changeStudyPlan(StudyPlan studyPlan, UpdateStudyPlanRequest dto) {
    studyPlan.setBook(dto.getBook());
    studyPlan.setRule(dto.getRule());
    studyPlan.setTitle(dto.getTitle());
    studyPlan.setTeamMember(dto.getTeamMember());
  }

  public List<StudyPlanResponse> getAll() {
    return studyPlanRepository.findAll().stream()
        .map(studyPlanMapper::mapToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  public StudyPlanResponse delete(Long studyGroupId) {
    // studyPlanRepository.delete(dto.toEntity());
    StudyPlan studyPlan = getEntity(studyGroupId);
    studyPlan.getBaseTime().delete();

    return studyPlanMapper.mapToDTO(studyPlan);
  }

  public StudyPlan getEntity(Long studyGorupId) {
    return studyPlanRepository.findById(studyGorupId).orElseThrow(EntityNotFoundException::new);
  }
}
