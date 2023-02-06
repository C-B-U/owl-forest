package com.cbu.backend.studygroup;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;
    private final StudyGroupMapper studyGroupMapper;

    public Long saveStudyGroup(StudyGroupRequest studyGroupRequest) {
        checkParticipantDuplicated(studyGroupRequest.getMembers());
        return studyGroupRepository.save(studyGroupMapper.toEntity(studyGroupRequest)).getId();
    }

    @Transactional
    public void updateStudyGroup(Long id, StudyGroupRequest studyGroupRequest) {
        StudyGroup studyGroup = getEntity(id);
        checkParticipantDuplicated(studyGroupRequest.getMembers());
        studyGroup.updateStudyGroup(
                studyGroupRequest.getName(), studyGroupRequest.getDescription());
    }

    @Transactional
    public void addLike(Long id, Member member) {
        StudyGroup studyGroup = getEntity(id);
        LikeCount likeCount = new LikeCount(member, studyGroup);
        likeCount.addLike(studyGroup);
    }

    @Transactional
    public void cancelLike(Long id, Member member) {
        //        LikeCount likeCount =
        //                studyGroupRepository
        //                        .findLikeCountByIdAndMember(id, member)
        //                        .orElseThrow(EntityNotFoundException::new);
        //        likeCount.getStudyGroup().cancelLike(likeCount);
    }

    @Transactional
    public void finishStudy(Long id) {
        getEntity(id).finishStudy();
    }

    @Transactional
    public void deleteStudyGroup(Long id) {
        getEntity(id).deleteStudy();
    }

    public StudyGroupResponse findResponseById(Long id) {
        return studyGroupMapper.toResponse(getEntity(id));
    }

    public List<StudyGroupResponse> findAllStudyGroup(Pageable pageable) {
        return studyGroupRepository.findAll(pageable).stream()
                .map(studyGroupMapper::toResponse)
                .collect(Collectors.toList());
    }

    private void checkParticipantDuplicated(List<Long> studyGroupParticipants) {
        if (studyGroupParticipants.size() != getRequestCount(studyGroupParticipants)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<Long> studyGroupParticipants) {
        return studyGroupParticipants.stream().distinct().count();
    }

    private StudyGroup getEntity(Long id) {
        return studyGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
