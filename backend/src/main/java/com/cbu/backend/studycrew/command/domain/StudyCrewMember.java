package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyCrewMember {

    private AccountNo studyCrewLeaderId;

    @ElementCollection
    @CollectionTable(
            name = "study_crew_participants",
            joinColumns = @JoinColumn(name = "study_crew_id"))
    private Set<AccountNo> studyCrewParticipantIds = new HashSet<>();

    public StudyCrewMember(AccountNo studyCrewLeaderId, List<AccountNo> studyCrewParticipantIds) {
        checkParticipantNotDuplicated(studyCrewParticipantIds);
        this.studyCrewLeaderId = studyCrewLeaderId;
        this.studyCrewParticipantIds.addAll(studyCrewParticipantIds);
    }
}
