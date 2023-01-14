package com.cbu.backend.authaccount.command.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Embedded
    MemberPublicInfo memberPublicInfo = new MemberPublicInfo();

    @Embedded MemberPrivacy memberPrivacy = new MemberPrivacy();

    @Builder
    public Member(
            String name,
            String nickname,
            MemberPublicInfo memberPublicInfo,
            MemberPrivacy memberPrivacy) {
        this.name = name;
        this.nickname = nickname;
        this.memberPublicInfo = memberPublicInfo;
        this.memberPrivacy = memberPrivacy;
    }
}
