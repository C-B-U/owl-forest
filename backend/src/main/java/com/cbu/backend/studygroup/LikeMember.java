package com.cbu.backend.studygroup;

import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.domain.Member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeMember {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Embedded private BaseTime baseTime;

    @Builder
    public LikeMember(Member member, StudyGroup studyGroup) {
        this.member = member;
        this.studyGroup = studyGroup;
        addLike();
        this.baseTime = new BaseTime();
    }

    public void addLike() {
        studyGroup.getLikeMember().add(this);
    }

    public void cancelLike() {
        if (studyGroup.getLikeMember().isEmpty()) {
            throw new LikeCountMinusException();
        }
        studyGroup.getLikeMember().remove(this);
    }
}
