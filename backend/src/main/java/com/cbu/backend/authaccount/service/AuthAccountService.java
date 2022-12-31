package com.cbu.backend.authaccount.service;

import com.cbu.backend.authaccount.entity.AuthAccount;
import com.cbu.backend.authaccount.repository.AuthAccountRepository;
import com.cbu.backend.config.security.oauth2.OAuth2Request;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthAccountService {
  private final AuthAccountRepository authAccountRepository;
  private final MemberService memberService;

  public AuthAccount findByAccountId(String accountId) {
    return authAccountRepository
        .findByAccountId(accountId)
        .orElseThrow(EntityNotFoundException::new);
  }

  private boolean isExistByAccountId(String accountId) {
    return authAccountRepository.existsByAccountId(accountId);
  }

  @Transactional
  public AuthAccount createIfFirst(OAuth2Request oAuth2Request) {
    String accountId = oAuth2Request.getAccountId();
    if (isExistByAccountId(accountId)) {
      return findByAccountId(accountId);
    }
    Member member = setUpMember(oAuth2Request);
    memberService.save(member); // TODO SAVE 호출 안해도 JPA에서 AUTO SAVE 하는지 확인
    AuthAccount authAccount = setUpAuthAccount(oAuth2Request, member);
    authAccountRepository.save(authAccount);

    return authAccount;
  }

  public Collection<? extends GrantedAuthority> getAuthority(UUID id) {
    return getEntity(id).getRole();
  }

  private AuthAccount setUpAuthAccount(OAuth2Request oAuth2Request, Member member) {
    return AuthAccount.builder()
        .accountId(oAuth2Request.getAccountId())
        .authProvider(oAuth2Request.getProvider())
        .member(member)
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
    oAuth2Request.getEmail().ifPresent(memberBuilder::email);

    return memberBuilder.build();
  }

  private AuthAccount getEntity(UUID id) {
    return authAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
