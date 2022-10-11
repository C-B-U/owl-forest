package com.cbu.backend.studyactivitylog.entity;

import com.cbu.backend.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyActivityLog {
    @Id
    @GeneratedValue
    private Long id;

    private Integer count;
    
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String place;

    @OneToMany(mappedBy = "member")
    private List<Member> teamMembers = new ArrayList<>();

    private String activityDetail;
}
