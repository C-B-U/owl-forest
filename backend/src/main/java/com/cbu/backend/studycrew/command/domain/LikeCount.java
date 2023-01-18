package com.cbu.backend.studycrew.command.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {

    private Integer count;

    public LikeCount(Integer count) {
        this.count = count;
    }

    public LikeCount addCount() {
        return new LikeCount(count + 1);
    }

    public LikeCount cancelLike() {
        if(count <= 0) {
            throw new LikeCountMinusException();
        }
        return new LikeCount(count - 1);
    }
}
