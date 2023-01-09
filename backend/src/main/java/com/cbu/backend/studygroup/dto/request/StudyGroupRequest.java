package com.cbu.backend.studygroup.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 스터디 그룹에 대한 Request DTO
 *
 * @author ohksj(김승진)
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupRequest {
    private String name;
    private String description;
    private Long studyGroupLeader;
    private List<Long> studyGroupMembers = new ArrayList<>();
    private Integer season;
}
