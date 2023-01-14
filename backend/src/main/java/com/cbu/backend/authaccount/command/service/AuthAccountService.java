package com.cbu.backend.authaccount.command.service;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.authaccount.command.domain.AuthAccount;
import com.cbu.backend.authaccount.command.domain.Member;
import com.cbu.backend.authaccount.command.domain.MemberPublicInfo;
import com.cbu.backend.authaccount.command.domain.MemberRequest;
import com.cbu.backend.authaccount.command.infra.AuthAccountRepository;
import com.cbu.backend.config.security.oauth2.OAuth2Request;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;
import java.util.UUID;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthAccountService {
    private final AuthAccountRepository authAccountRepository;

    @Transactional
    public AuthAccount saveIfNone(OAuth2Request oAuth2Request) {
        String socialId = oAuth2Request.getAccountId();
        return authAccountRepository
                .findById_SocialId(socialId)
                .orElseGet(
                        () ->
                                authAccountRepository.save(
                                        setUpAuthAccount(
                                                oAuth2Request, setUpMember(oAuth2Request))));
    }

    public Collection<? extends GrantedAuthority> getAuthority(UUID id) {
        // TODO 로그인 유저 불러오기 구현
        // return getEntity(id).getRole();
        return null;
    }

    private AuthAccount setUpAuthAccount(OAuth2Request oAuth2Request, Member member) {
        return AuthAccount.builder()
                .accountNo(new AccountNo(oAuth2Request.getAccountId()))
                .authProvider(oAuth2Request.getProvider())
                .member(member)
                .build();
    }

    public Member getLoginUser(Principal principal) {
        // TODO 로그인 유저 불러오기 구현
        // return getEntity(UUID.fromString(principal.getName())).getMember();
        return null;
    }

    private Member setUpMember(OAuth2Request oAuth2Request) {
        Member.MemberBuilder memberBuilder = Member.builder();

        oAuth2Request
                .getName()
                .ifPresent(
                        n -> {
                            memberBuilder.name(n);
                            memberBuilder.nickname(n);
                        });
        MemberPublicInfo.MemberPublicInfoBuilder memberPublicInfoBuilder =
                MemberPublicInfo.builder();
        oAuth2Request.getEmail().ifPresent(memberPublicInfoBuilder::email);

        return memberBuilder.memberPublicInfo(memberPublicInfoBuilder.build()).build();
    }

    @Transactional
    public void registerMember(Principal principal, MemberRequest dto) {
        AuthAccount authAccount = null; // TODO 로그인 유저 불러오기 구현
        authAccount.register(dto.toEntity());
    }
}
