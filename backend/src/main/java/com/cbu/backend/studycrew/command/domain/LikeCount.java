package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {

    private Integer count;

    @ElementCollection
    private List<MemberLikeCount> memberLikeCounts;

    private LikeCount(Integer count, MemberLikeCount memberLikeCount, List<MemberLikeCount> memberLikeCounts) {
        this.count = count;
        this.memberLikeCounts = memberLikeCounts;
        this.memberLikeCounts.add(memberLikeCount);
    }

    public LikeCount(Integer count) {
        this.count = count;
        this.memberLikeCounts = new ArrayList<>();
    }

    public LikeCount addCount(AccountNo memberId) {
        return new LikeCount(count + 1, new MemberLikeCount(memberId, true), memberLikeCounts);
    }

    public LikeCount cancelLike(AccountNo memberId) {
        if (count <= 0) {
            throw new LikeCountMinusException();
        }
        return new LikeCount(count - 1, new MemberLikeCount(memberId, false), memberLikeCounts);
    }
}
