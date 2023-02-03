package com.cbu.backend.studygroup.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {

    @ElementCollection private Set<AccountNo> memberIds = new HashSet<>();

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
