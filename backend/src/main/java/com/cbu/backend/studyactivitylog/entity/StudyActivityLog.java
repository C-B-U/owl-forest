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

    private Integer week;
    
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    private List<Long> teamMembers = new ArrayList<>();

    private String activityDetail;

    @Builder
    public StudyActivityLog(Integer week, LocalDateTime startTime, LocalDateTime endTime, String place, StudyGroup studyGroup, String activityDetail) {
        this.count = count;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.studyGroup = studyGroup;
        this.activityDetail = activityDetail;
    }
}
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private StudyGroup studyGroup;
}
