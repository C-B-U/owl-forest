package com.cbu.backend.studygroup.query.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class StudyGroupResponse {
    private StudyGroupInfo studyGroupInfo;
    private List<StudyMemberInfo> participants;

    public StudyGroupResponse(StudyGroupInfo studyGroupInfo, List<StudyMemberInfo> participants) {
        this.studyGroupInfo = studyGroupInfo;
        this.participants = participants;
    }
}
