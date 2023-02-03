package com.cbu.backend.support.fixture.member.entity;

import com.cbu.backend.authaccount.command.domain.*;

import java.util.ArrayList;
import java.util.List;

public enum AuthAccountFixture {
    SAMPLE1(
            new AccountNo(),
            new Member("홍길동", "가나다라", new MemberPublicInfo(), new MemberPrivacy()),
            "12345"),
    SAMPLE2(
            new AccountNo(),
            new Member("심청", "나나나", new MemberPublicInfo(), new MemberPrivacy()),
            "123456"),
    SAMPLE3(
            new AccountNo(),
            new Member("하하", "바사바사", new MemberPublicInfo(), new MemberPrivacy()),
            "1234567");
    private final AccountNo id;

    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    private AuthProvider authProvider = AuthProvider.NONE;

    private final Member memberInfo;
    private final String socialId;

    private boolean isUpdate = false;

    AuthAccountFixture(AccountNo id, Member memberInfo, String socialId) {
        this.id = id;
        this.memberInfo = memberInfo;
        this.socialId = socialId;
    }

    public AuthAccount toEntity() {
        return new AuthAccount(id, authProvider, socialId, memberInfo);
    }
}
