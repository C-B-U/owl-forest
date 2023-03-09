package com.cbu.backend.studyactivity;

import com.cbu.backend.global.IdResponse;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;
import com.cbu.backend.studygroup.StudyGroup;
import com.cbu.backend.studygroup.StudyGroupService;
import com.cbu.backend.studygroup.StudyMember;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyActivityService {

    private final StudyActivityRepository studyActivityRepository;
    private final MemberService memberService;
    private final StudyActivityMapper studyActivityMapper;
    private final StudyGroupService studyGroupService;

    public IdResponse<Long> saveStudyActivity(StudyActivityRequest request) {
        checkStudyTime(request);
        StudyGroup studyGroup = studyGroupService.getEntity(request.getStudyGroupId());
        Set<StudyMember> members =
                request.getActivityMembers().stream()
                        .map(memberService::getEntity)
                        .map(member -> new StudyMember(studyGroup, member))
                        .collect(Collectors.toSet());
        Long id =
                studyActivityRepository
                        .save(studyActivityMapper.toEntity(request, members))
                        .getId();

        return new IdResponse<>(id);
    }

    public void updateStudyActivity(Long id, StudyActivityRequest request) {
        checkStudyTime(request);
        StudyGroup studyGroup = studyGroupService.getEntity(request.getStudyGroupId());
        Set<StudyMember> members =
                request.getActivityMembers().stream()
                        .map(memberService::getEntity)
                        .map(member -> new StudyMember(studyGroup, member))
                        .collect(Collectors.toSet());

        getEntity(id)
                .update(
                        request.getTitle(),
                        request.getDescription(),
                        request.getAssignment(),
                        request.getWeek(),
                        request.getPlace(),
                        members,
                        request.getStudyGroupId(),
                        request.getStudyTime());
    }

    @Transactional
    public void deleteStudyActivity(Long id) {
        getEntity(id).delete();
    }

    public StudyActivityResponse findStudyActivity(Long id) {
        return studyActivityMapper.toResponse(getEntity(id));
    }

    public List<StudyActivityResponse> findStudyActivityListByStudyGroupId(Long studyGroupId) {
        return studyActivityRepository.findAllByStudyGroupId(studyGroupId).stream()
                .map(studyActivityMapper::toResponse)
                .toList();
    }

    private void checkStudyTime(StudyActivityRequest studyActivityRequest) {
        studyActivityRequest.getStudyTime().validStudyTime();
    }

    private StudyActivity getEntity(Long id) {
        return studyActivityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
