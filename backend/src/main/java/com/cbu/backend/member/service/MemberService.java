package com.cbu.backend.member.service;

import com.cbu.backend.config.security.oauth2.OAuth2Request;
import com.cbu.backend.member.MemberMapper;
import com.cbu.backend.member.MemberRepository;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.domain.OAuth2Info;
import com.cbu.backend.member.dto.MemberPrivacyResponse;
import com.cbu.backend.member.dto.MemberResponse;
import com.cbu.backend.member.dto.MemberSummaryResponse;
import com.cbu.backend.member.dto.UpdateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final AuthService authService;

    @Transactional
    public Member saveIfNone(OAuth2Request oAuth2Request) {
        String socialId = oAuth2Request.getAccountId();
        return memberRepository
                .findByoAuth2InfoSocialId(socialId)
                .orElseGet(() -> memberRepository.save(setUpMember(oAuth2Request)));
    }

    public Member getEntity(UUID id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private Member setUpMember(OAuth2Request req) {
        OAuth2Info oAuth2Info = new OAuth2Info(req.getProvider(), req.getAccountId());
        Member.MemberBuilder memberBuilder = Member.builder().oAuth2Info(oAuth2Info);
        req.getName().ifPresent(memberBuilder::name);
        req.getEmail().ifPresent(memberBuilder::email);
        return memberBuilder.build();
    }

    @Transactional
    public void update(UpdateMemberRequest req) {
        Member loginUser = authService.getLoginUser();
        loginUser.update(req.getName(), req.getBlogUrl(), req.getEmail(), req.getAcademicStatus(), req.getMajor(), req.getEmail(), req.getGrade(), req.getStudentId(), req.getProfileUrl(), req.getPhoneNumber(), req.getIntroduction());
    }

    public List<MemberSummaryResponse> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable).getContent().stream()
                .map(memberMapper::toSummaryDto)
                .toList();
    }

    public MemberResponse findById(UUID id) {
        return memberMapper.toDto(getEntity(id));
    }

    public MemberPrivacyResponse findPrivacyById(UUID id) {
        return memberMapper.toPrivacyDto(getEntity(id));
    }
}
