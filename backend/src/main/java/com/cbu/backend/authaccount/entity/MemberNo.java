package com.cbu.backend.authaccount.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberNo {
    private Long id;

    public MemberNo(Long id) {
        this.id = id;
    }
}
