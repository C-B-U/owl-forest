package com.cbu.backend.studyactivitylog.dto.request;

import com.cbu.backend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudyActivityLogRequestDTO {
    private Integer count;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String place;
    private List<Member> teamMembers = new ArrayList<>();
    private String activityDetail;
}