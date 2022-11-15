package com.cbu.backend.studygroup.service;

import com.cbu.backend.studyactivitylog.service.StudyActivityLogService;
import com.cbu.backend.studygroup.dto.request.CreateStudyGroupRequestDTO;
import com.cbu.backend.studygroup.dto.response.StudyGroupResponseDTO;
import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studygroup.mapper.StudyGroupMapper;
import com.cbu.backend.studygroup.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;
    private final StudyGroupMapper studyGroupMapper;
    private final StudyActivityLogService studyActivityLogService;

    // CreateStudyGroupRequestDTO 이름 변경, toEntity 광범위한 이름
    public StudyGroupResponseDTO registerStudyGroup(CreateStudyGroupRequestDTO createStudyGroupRequestDTO) { // 스터디 등록
        StudyGroup studyGroup = studyGroupMapper.mapToEntity(createStudyGroupRequestDTO);
        studyGroupRepository.save(studyGroup);

        return studyGroupMapper.toResponseDTO(studyGroup);
    }

    public StudyGroupResponseDTO searchById(Long id) { // 스터디 ID로 조회
        Optional<StudyGroup> studyGroup = studyGroupRepository.findById(id);
        if (!studyGroup.isPresent()) { // 조회 실패
            throw new EntityNotFoundException();
        }
        return studyGroupMapper.toResponseDTO(studyGroup.get());
    }

    public void updateLikeCount(Long studyGroupId, Integer likeCount) { // 스터디 좋아요 업데이트(Integer like는 -1 or +1)
        studyGroupRepository
                .findById(studyGroupId)
                .ifPresent(studyGroup -> studyGroup.updateLike(likeCount));
    }

    public List<StudyGroupResponseDTO> searchStudyOrderByCreatedAt(Comparator<Comparable> sortDirection) { // 스터디 일지 최신순 조회
        return sort(studyActivityLogService::searchLatestStudyActivityLogCreatedAt, sortDirection);
    }

    public List<StudyGroupResponseDTO> searchStudyOrderByStudyActivityLog(Comparator<Comparable> sortDirection) { // 스터디 일지 개수순 조회
        return sort(studyGroup -> studyGroup.getStudyActivityLogs().size(), sortDirection);
    }

    public List<StudyGroupResponseDTO> searchStudyOrderByLikeCount(Comparator<Comparable> sortDirection) { // 스터디 좋아요순(많은 순서) 조회
        return sort(StudyGroup::getLikeCount, sortDirection);
    }

    private List<StudyGroupResponseDTO> sort(Function<StudyGroup, Comparable> function, Comparator<Comparable> sortDirection) {
        return studyGroupRepository
                .findAll()
                .stream()
                .sorted(Comparator.comparing(function, sortDirection)
                        .thenComparing(StudyGroup::getSeason, Comparator.reverseOrder()))
                .map(studyGroupMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateStudyGroup(Long studyGroupId, CreateStudyGroupRequestDTO createStudyGroupRequestDTO) { // 스터디 수정
        Optional<StudyGroup> oStudyGroup = studyGroupRepository.findById(studyGroupId);
        if (!oStudyGroup.isPresent()) {
            throw new RuntimeException();
        }
        StudyGroup studyGroup = oStudyGroup.get();
        StudyGroup updatedStudyGroup = studyGroupMapper.mapToEntity(createStudyGroupRequestDTO);
        studyGroup.update(updatedStudyGroup);
    }
}
