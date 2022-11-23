package com.cbu.backend.studygroup.entity;

import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroup {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String summary;

    @OneToMany(mappedBy = "studyGroup")
    private List<StudyActivityLog> studyActivityLogs = new ArrayList<>();

    private Integer likeCount = 0;

    private Integer season;

    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    private StudyGroupMember studyGroupLeader;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studyGroup")
    private List<StudyGroupMember> studyGroupMembers = new ArrayList<>();

    @Embedded
    private BaseTime baseTime;

    @Builder
    public StudyGroup(String name, String summary, List<StudyActivityLog> studyActivityLogs, Integer season,
                      StudyGroupMember studyGroupLeader, List<StudyGroupMember> studyGroupMembers) {
        this.name = name;
        this.summary = summary;
        this.studyActivityLogs = studyActivityLogs;
        this.season = season;
        this.studyGroupLeader = studyGroupLeader;
        this.studyGroupMembers = studyGroupMembers;
    }

    public StudyGroup update(StudyGroup studyGroup) { // 매개변수 request DTO로 수정 필요
        this.name = studyGroup.getName();
        this.summary = studyGroup.getSummary();

        return this;
    }

    public void updateLike(Integer like) { // like는 -1(좋아요 취소) or +1(좋아요)
        if(isPositive(like)){
            this.likeCount += like;
        }
    }

    private boolean isPositive(Integer like) {
        return this.likeCount + like >= 0;
    }

    public void updateIsActive() {
        this.isActive = !this.isActive;
    }

}