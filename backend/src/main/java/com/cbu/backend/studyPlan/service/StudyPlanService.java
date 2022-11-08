package com.cbu.backend.studyPlan.service;

import com.cbu.backend.studyPlan.dto.request.StudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.request.UpdateStudyPlanRequestDTO;
import com.cbu.backend.studyPlan.dto.response.StudyPlanResponseDTO;
import com.cbu.backend.studyPlan.entity.StudyPlan;
import com.cbu.backend.studyPlan.mapper.StudyPlanMapper;
import com.cbu.backend.studyPlan.repository.StudyPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyPlanService {

    private final StudyPlanRepository studyPlanRepository;
    private final StudyPlanMapper studyPlanMapper;

    // 스터디 계획서 생성
    @Transactional
    public StudyPlanResponseDTO create(StudyPlanRequestDTO requestDto, Long studyGroupId) {
        StudyPlan studyPlan = studyPlanMapper.mapToEntity(requestDto);
        studyPlanRepository.save(studyPlan);

        return studyPlanMapper.mapToDTO(studyPlan);
    }

    @Transactional
    // 스터디 계획서 수정 (미완)
    public StudyPlanResponseDTO update(UpdateStudyPlanRequestDTO dto, Long studyPlanId){
//        Optional<StudyPlan> update = studyPlanRepository.findById(studyPlanId);
//        StudyPlan studyPlan = studyPlanMapper.mapToEntity(dto);
        StudyPlan studyPlan = getEntity(studyPlanId);
        changeStudyPlan(studyPlan, dto);

        return studyPlanMapper.mapToDTO(studyPlan);
    }

    private void changeStudyPlan(StudyPlan studyPlan, UpdateStudyPlanRequestDTO dto){
        studyPlan.setBook(dto.getBook());
        studyPlan.setRule(dto.getRule());
        studyPlan.setTitle(dto.getTitle());
        studyPlan.setTeamMember(dto.getTeamMember());
    }

    public List<StudyPlanResponseDTO> getAll(){
        return studyPlanRepository.findAll()
                .stream()
                .map(studyPlanMapper::mapToDTO)
                .collect(Collectors.toList());

    }

    @Transactional
    public StudyPlanResponseDTO delete(Long studyGroupId){
        //studyPlanRepository.delete(dto.toEntity());
        StudyPlan studyPlan = getEntity(studyGroupId);
        studyPlan.getBaseTime().delete();

        return studyPlanMapper.mapToDTO(studyPlan);
    }

    public StudyPlan getEntity(Long studyGorupId){
        return studyPlanRepository.findById(studyGorupId)
                .orElseThrow(EntityNotFoundException::new);
    }
}
