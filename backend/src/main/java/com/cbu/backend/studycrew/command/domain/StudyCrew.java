package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.studycrew.command.dto.StudyCrewRequest;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyCrew {

    @EmbeddedId private StudyCrewNo id;

    @Column(nullable = false)
    private String name;

    @Lob private String description;

    @Column(nullable = false)
    @Embedded
    private LikeCount likeCount;

    @Enumerated(EnumType.STRING)
    private StudyCrewStatus studyCrewStatus;

    @Embedded private StudyCrewMember studyCrewMember;

    @Embedded private BaseTime baseTime;

    @Builder
    public StudyCrew(
            String name, String description, AccountNo leaderId, List<AccountNo> participantIds) {
        this.id = new StudyCrewNo();
        this.name = name;
        this.description = description;
        this.likeCount = new LikeCount(0);
        this.studyCrewStatus = StudyCrewStatus.ACTIVE;
        this.studyCrewMember = new StudyCrewMember(leaderId, participantIds);
        this.baseTime = new BaseTime();
    }

    public StudyCrew updateStudyCrew(StudyCrewRequest studyCrewRequest) {
        this.name = studyCrewRequest.getName();
        this.description = studyCrewRequest.getDescription();
        this.studyCrewMember =
                new StudyCrewMember(
                        studyCrewRequest.getLeader(), studyCrewRequest.getParticipants());
        return this;
    }

    public void finishStudyCrew() {
        studyCrewStatus = StudyCrewStatus.FINISHED;
    }

    public void deleteStudyCrew() {
        baseTime.delete();
    }

    public void cancelLike(AccountNo memberId) {
        likeCount = likeCount.cancelLike(memberId);
    }

    public void addLike(AccountNo memberId) {
        likeCount = likeCount.addCount(memberId);
    }
}
