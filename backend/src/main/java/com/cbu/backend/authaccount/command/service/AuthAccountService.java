package com.cbu.backend.authaccount.command.service;

import com.cbu.backend.authaccount.command.domain.*;
import com.cbu.backend.authaccount.command.infra.AuthAccountRepository;
import com.cbu.backend.config.security.oauth2.OAuth2Request;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthAccountService {
    private final AuthAccountRepository authAccountRepository;

    @Transactional
    public AuthAccount saveIfNone(OAuth2Request oAuth2Request) {
        String socialId = oAuth2Request.getAccountId();
        return authAccountRepository
                .findBySocialId(socialId)
                .orElseGet(
                        () ->
                                authAccountRepository.save(
                                        setUpAuthAccount(
                                                oAuth2Request, setUpMember(oAuth2Request))));
    }

    private AuthAccount setUpAuthAccount(OAuth2Request oAuth2Request, Member member) {
        return AuthAccount.builder()
                .accountNo(new AccountNo())
                .socialId(oAuth2Request.getAccountId())
                .authProvider(oAuth2Request.getProvider())
                .memberInfo(member)
                .build();
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
    public void updateMemberInfo(Principal principal, MemberRequest dto) {
        AuthAccount authAccount = getByUUID(UUID.fromString(principal.getName()));
        authAccount.updateMemberInfo(dto.toEntity());
    }

    private AuthAccount getByUUID(UUID id) {
        return authAccountRepository.findById_Id(id).orElseThrow(EntityNotFoundException::new);
    }
}
