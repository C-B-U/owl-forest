package com.cbu.backend.studygroup.command.service;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studygroup.command.domain.StudyGroup;
import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.command.dto.StudyGroupRequest;
import com.cbu.backend.studygroup.command.infra.StudyGroupRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupNo save(StudyGroupRequest studyGroupRequest) {
        checkParticipantDuplicated(studyGroupRequest.getParticipants());
        return studyGroupRepository.save(studyGroupRequest.toEntity()).getId();
    }

    @Transactional
    public void updateStudyGroup(StudyGroupNo id, StudyGroupRequest studyGroupRequest) {
        StudyGroup studyGroup = getEntity(id);
        checkParticipantDuplicated(studyGroupRequest.getParticipants());
        studyGroup.updateStudyGroup(
                studyGroupRequest.getName(),
                studyGroupRequest.getDescription(),
                studyGroupRequest.getLeader(),
                studyGroupRequest.getParticipants());
    }

    @Transactional
    public void addLike(StudyGroupNo id, AccountNo accountId) {
        getEntity(id).addLike(accountId);
    }

    @Transactional
    public void cancelLike(StudyGroupNo id, AccountNo accountId) {
        getEntity(id).cancelLike(accountId);
    }

    @Transactional
    public void finishStudy(StudyGroupNo id) {
        getEntity(id).finishStudy();
    }

    @Transactional
    public void deleteStudyGroup(StudyGroupNo id) {
        getEntity(id).deleteStudyGroup();
    }

    private void checkParticipantDuplicated(List<AccountNo> studyGroupParticipants) {
        if (studyGroupParticipants.size() != getRequestCount(studyGroupParticipants)) {
            throw new ParticipantDuplicatedException();
        }
    }

    private long getRequestCount(List<AccountNo> studyGroupParticipants) {
        return studyGroupParticipants.stream().distinct().count();
    }

    private StudyGroup getEntity(StudyGroupNo id) {
        return studyGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
