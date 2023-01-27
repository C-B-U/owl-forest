package com.cbu.backend.studygroup.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.global.BaseTime;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroup {

    @EmbeddedId private StudyGroupNo id;

    @Column(nullable = false)
    private String name;

    @Lob private String description;

    @Column(nullable = false)
    @Embedded
    private LikeCount likeCount;

    @Enumerated(EnumType.STRING)
    private StudyGroupStatus studyGroupStatus;

    @Embedded private StudyGroupMember studyGroupMember;

    @Embedded private BaseTime baseTime;

    @Builder
    public StudyGroup(
            String name, String description, AccountNo leaderId, List<AccountNo> participantIds) {
        this.id = new StudyGroupNo();
        this.name = name;
        this.description = description;
        this.likeCount = new LikeCount();
        this.studyGroupStatus = StudyGroupStatus.ACTIVE;
        this.studyGroupMember = new StudyGroupMember(leaderId, participantIds);
        this.baseTime = new BaseTime();
    }

    public void updateStudyGroup(
            String name, String description, AccountNo leaderId, List<AccountNo> participantIds) {
        this.name = name;
        this.description = description;
        this.studyGroupMember = new StudyGroupMember(leaderId, participantIds);
    }

    public void finishStudy() {
        studyGroupStatus = StudyGroupStatus.FINISHED;
    }

    public void deleteStudyGroup() {
        baseTime.delete();
    }

    public void cancelLike(AccountNo memberId) {
        likeCount.cancelLike(memberId);
    }

    public void addLike(AccountNo memberId) {
        likeCount.addCount(memberId);
    }
}
