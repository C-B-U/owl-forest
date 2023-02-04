package com.cbu.backend.studygroup.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "study_group_like",
            joinColumns = @JoinColumn(name = "study_group_id"))
    private Set<AccountNo> memberIds = new HashSet<>();

    public LikeCount(Set<AccountNo> memberIds) {
        this.memberIds = memberIds;
    }

    public void addCount(AccountNo memberId) {
        memberIds.add(memberId);
    }

    public void cancelLike(AccountNo memberId) {
        if (memberIds.isEmpty()) {
            throw new LikeCountMinusException();
        }
        memberIds.remove(memberId);
    }
}
