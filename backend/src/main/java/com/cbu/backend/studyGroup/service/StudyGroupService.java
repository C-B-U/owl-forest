package com.cbu.backend.studyGroup.service;

import com.cbu.backend.studyGroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studyGroup.entity.StudyGroup;
import com.cbu.backend.studyGroup.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    public void updateLike(Long studyGroupId, Integer like) {
        studyGroupRepository
                .findById(studyGroupId)
                .ifPresent(studyGroup -> studyGroup.updateLike(like));
    }

}
