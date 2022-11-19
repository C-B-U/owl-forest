package com.cbu.backend.studygroup.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupRequest {
    private String name;
    private String summary;
    private Long studyGroupLeader;
    private List<Long> studyGroupMembers = new ArrayList<>();
    private Integer likeCount;
    private Integer season;
}
