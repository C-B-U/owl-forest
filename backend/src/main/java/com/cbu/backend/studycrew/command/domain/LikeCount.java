package com.cbu.backend.studycrew.command.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCount {

    Integer count = 0;

    public void addLike() {
        count++;
    }

    public void cancelLike() {
        count--;
    }
}
