package com.cbu.backend.member;

import com.cbu.backend.config.security.oauth2.OAuth2Request;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.domain.OAuth2Info;
import com.cbu.backend.member.dto.UpdateMemberRequest;
import com.cbu.backend.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public Member saveIfNone(OAuth2Request oAuth2Request) {
        String socialId = oAuth2Request.getAccountId();
        return memberRepository
                .findByoAuth2InfoSocialId(socialId)
                .orElseGet(() -> memberRepository.save(setUpMember(oAuth2Request)));
    }

    public Member findById(UUID id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private Member setUpMember(OAuth2Request req) {
        OAuth2Info oAuth2Info = new OAuth2Info(req.getProvider(), req.getAccountId());
        Member.MemberBuilder memberBuilder = Member.builder().oAuth2Info(oAuth2Info);
        req.getName().ifPresent(memberBuilder::name);
        req.getEmail().ifPresent(memberBuilder::email);
        return memberBuilder.build();
    }

    public void update(UpdateMemberRequest req) {
        Member loginUser = AuthUtils.getLoginUser();
        memberMapper.updateFromDto(req, loginUser);
    }
}
