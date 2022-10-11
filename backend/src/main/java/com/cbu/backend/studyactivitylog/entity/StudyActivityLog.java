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
@Table(name = "studyActivityLog")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyActivityLog {
    @Id
    @GeneratedValue
    private Long Id;

    private Integer count;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime endTime;

    private String place;

    @OneToMany(mappedBy = "member")
    private List<Member> teamMembers = new ArrayList<>();

    private String activityDetail;
}
