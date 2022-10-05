package com.cbu.backend.studyGroup.service;

import com.cbu.backend.studyGroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studyGroup.entity.StudyGroup;
import com.cbu.backend.studyGroup.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException; // Exception 수정 필요
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    /*
    public Long registerStudyGroup(CreateStudyGroupRequestDTO createStudyGroupRequestDTO) {
        StudyGroup studyGroup = createStudyGroupRequestDTO.toStudyGroup();
        if(studyGroup.isDuplicatedMember(studyGroup)){
            throw new RuntimeException(); // Exception 수정 필요
        }
        studyGroupRepository.save(studyGroup);
        return studyGroup.getId();
    }
    */

    public StudyGroup searchById(Long id) {
        Optional<StudyGroup> studyGroup = studyGroupRepository.findById(id);
        if(!studyGroup.isPresent()) {
            throw new EntityNotFoundException();
        }
        return studyGroup.get();
    }

    public void updateLike(Long studyGroupId, Integer like) {
        studyGroupRepository
                .findById(studyGroupId)
                .ifPresent(studyGroup -> studyGroup.updateLike(like));
    }

}
