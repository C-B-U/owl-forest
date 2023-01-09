package com.cbu.backend.studyplan.service;

import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studygroup.service.StudyGroupService;
import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import com.cbu.backend.studyplan.dto.response.StudyPlanResponse;
import com.cbu.backend.studyplan.entity.StudyPlan;
import com.cbu.backend.studyplan.mapper.StudyPlanMapper;
import com.cbu.backend.studyplan.repository.StudyPlanRepository;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

/**
 * 스터디 계획서 서비스 로직을 담당하는 클래스
 *
 * @author ohksj77(김승진)
 */
@Service
@RequiredArgsConstructor
public class StudyPlanService {

  private final StudyPlanRepository studyPlanRepository;
  private final StudyPlanMapper studyPlanMapper;
  private final StudyGroupService studyGroupService;

  // 스터디 계획서 생성
  public StudyPlanResponse create(StudyPlanRequest requestDto, Long studyGroupId) {
    StudyGroup studyGroup = studyGroupService.getEntity(studyGroupId);
    StudyPlan studyPlan = studyPlanMapper.toEntity(requestDto, studyGroup);
    studyPlanRepository.save(studyPlan);

    return studyPlanMapper.toResponse(studyPlan);
  }

  // 스터디 계획서 수정
  @Transactional
  public StudyPlanResponse update(StudyPlanRequest dto, Long studyGroupId) {
    StudyPlan studyPlan = getEntity(studyGroupId);
    studyPlan.update(dto);

    return studyPlanMapper.toResponse(studyPlan);
  }

  // 스터디 계획서 조회
  public StudyPlanResponse findStudyPlan(Long studyGroupId) {
    StudyPlan studyPlan =
        studyPlanRepository
            .findByStudyGroup(studyGroupId)
            .orElseThrow(EntityNotFoundException::new);

    return studyPlanMapper.toResponse(studyPlan);
  }

  // 스터디 계획서 삭제
  @Transactional
  public StudyPlanResponse delete(Long studyGroupId) {
    StudyPlan studyPlan = getEntity(studyGroupId);
    studyPlan.getBaseTime().delete();

    return studyPlanMapper.toResponse(studyPlan);
  }

  private StudyPlan getEntity(Long studyPlanId) {
    return studyPlanRepository.findById(studyPlanId).orElseThrow(EntityNotFoundException::new);
  }
}
