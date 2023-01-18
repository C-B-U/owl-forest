package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.global.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyCrew {

    @EmbeddedId private StudyCrewNo id;

    @Column(nullable = false)
    private String name;

    @Lob private String description;

    @Column(nullable = false)
    @Embedded private LikeCount likeCount;

    @Enumerated(EnumType.STRING)
    private StudyCrewStatus studyCrewStatus;

    @Embedded private StudyCrewMember studyCrewMember;

    @Embedded private BaseTime baseTime;

    @Builder
    public StudyCrew(
            String name,
            String description,
            AccountNo leaderId,
            List<AccountNo> participantIds) {
        this.id = new StudyCrewNo();
        this.name = name;
        this.description = description;
        this.likeCount = new LikeCount();
        this.studyCrewStatus = StudyCrewStatus.ACTIVE;
        this.studyCrewMember = new StudyCrewMember(leaderId, participantIds);
        this.baseTime = new BaseTime();
    }
}
