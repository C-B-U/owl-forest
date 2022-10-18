package com.cbu.backend.studygroup.entity;

import com.cbu.backend.common.domain.BaseTimeEntity;
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

    @OneToOne(fetch = FetchType.LAZY)
    private Member teamLeader;

    @OneToMany(mappedBy = "studyGroup")
    private List<StudyActivityLog> studyActivityLogs = new ArrayList<>();

    private Integer like = 0;

    private Integer season;

    @Embedded
    private BaseTimeEntity baseTime;

    @Builder
    public StudyGroup(Long id, String name, String summary, Member teamLeader,
                      List<StudyActivityLog> studyActivityLogs, Integer like, Integer season) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.teamLeader = teamLeader;
        this.studyActivityLogs = studyActivityLogs;
        this.like = like;
        this.season = season;
    }

    public StudyGroup update(StudyGroup studyGroup) { // 매개변수 request DTO로 수정 필요
        this.name = studyGroup.getName();
        this.summary = studyGroup.getSummary();
        this.teamLeader = studyGroup.getTeamLeader();

        return this;
    }

 /*   public boolean isMemberDuplicated(StudyGroup studyGroup) {
        return studyGroup.getTeamMembers()
                .stream()
                .distinct()
                .mapToInt(i -> 1)
                .sum() == studyGroup.getTeamMembers().size();
    }*/

    public void updateLike(Integer like) { // like는 -1(좋아요 취소) or +1(좋아요)
        if(isPositive(like)){
            this.like += like;
        }
    }

    private boolean isPositive(Integer like) {
        return this.like + like >= 0;
    }

}