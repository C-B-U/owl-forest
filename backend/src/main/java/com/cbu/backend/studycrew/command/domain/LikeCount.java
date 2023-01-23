package com.cbu.backend.studycrew.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {

    private Integer count;

    @Embedded private MemberLikeCount memberLikeCount;

    private LikeCount(Integer count, AccountNo memberId, Boolean isLikeStudyCrew) {
        this.count = count;
        this.memberLikeCount = new MemberLikeCount(memberId, isLikeStudyCrew);
    }

    public LikeCount(Integer count) {
        this.count = count;
    }

    public LikeCount addCount(AccountNo memberId) {
        if (memberLikeCount.getIsLikeStudyCrew()) {
            throw new LikeCountDuplicateException();
        }
        return new LikeCount(count + 1, memberId, true);
    }

    public LikeCount cancelLike(AccountNo memberId) {
        if (count <= 0) {
            throw new LikeCountMinusException();
        } else if (!memberLikeCount.getIsLikeStudyCrew()) {
            throw new LikeCountDuplicateException();
        }
        return new LikeCount(count - 1, memberId, false);
    }
}
