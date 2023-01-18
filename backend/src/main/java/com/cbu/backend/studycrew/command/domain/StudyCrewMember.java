package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyCrewMember {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "leader_id"))
    private AccountNo leaderId;

    @ElementCollection
    @CollectionTable(
            name = "study_crew_participant",
            joinColumns = @JoinColumn(name = "study_crew_id"))
    private Set<AccountNo> participantIds = new HashSet<>();

    public StudyCrewMember(AccountNo leaderId, List<AccountNo> participantIds) {
        this.leaderId = leaderId;
        this.participantIds.addAll(participantIds);
    }
}
