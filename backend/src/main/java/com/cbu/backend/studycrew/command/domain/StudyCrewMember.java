package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

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
        checkLeaderInParticipants(studyCrewLeaderId, studyCrewParticipantIds);
        checkParticipantNotDuplicated(studyCrewParticipantIds);
        this.studyCrewLeaderId = studyCrewLeaderId;
        this.studyCrewParticipantIds.addAll(studyCrewParticipantIds);
    }

    private void checkParticipantNotDuplicated(List<AccountNo> studyCrewParticipants) {
        if (studyCrewParticipants.size()
                != studyCrewParticipants.stream().distinct().mapToInt(o -> 1).sum()) {
            throw new RuntimeException("중복 멤버가 있습니다.");
        }
    }

    private void checkLeaderInParticipants(
            AccountNo studyCrewLeaderId, List<AccountNo> studyCrewParticipantIds) {
        if (studyCrewParticipantIds.stream()
                .anyMatch(participantId -> participantId.equals(studyCrewLeaderId))) {
            throw new RuntimeException("멤버 리스트에 리더가 중복됩니다.");
        }
    }
}
