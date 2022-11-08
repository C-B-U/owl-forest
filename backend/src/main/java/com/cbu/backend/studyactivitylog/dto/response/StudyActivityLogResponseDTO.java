package com.cbu.backend.studyactivitylog.dto.response;

import com.cbu.backend.member.entity.Member;

import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
public class StudyActivityLogResponseDTO {
    private Long id;
    private Integer count;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String place;
    private List<Member> teamMembers = new ArrayList<>();
    private String activityDetail;
    private String assignment;
}
