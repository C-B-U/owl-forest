package com.cbu.backend.studygroup;


import com.cbu.backend.authaccount.command.domain.Member;
import com.cbu.backend.global.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Embedded
    private BaseTime baseTime;

    @Builder
    public LikeCount(Member member, StudyGroup studyGroup) {
        this.member = member;
        this.studyGroup = studyGroup;
        addLike(studyGroup);
        this.baseTime = new BaseTime();
    }

    public void addLike(StudyGroup studyGroup) {
        studyGroup.getLikeCount().add(this);
    }
}
