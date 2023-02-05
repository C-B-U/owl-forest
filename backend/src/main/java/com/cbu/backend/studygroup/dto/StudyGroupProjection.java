package com.cbu.backend.studygroup.dto;

import com.cbu.backend.studygroup.StudyGroupStatus;

import java.util.List;

public interface StudyGroupProjection {
    String getName();
    String getDescription();
    Integer getLikeCount();
    StudyGroupStatus getStudyGroupStatus();
    StudyMemberInfo getLeader();
    List<StudyMemberInfo> getStudyMembers();

    interface StudyMemberInfo {
        Long getId();
        String getName();
    }
}
