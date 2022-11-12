package com.cbu.backend.member.service;

import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getEntity(Long id) {
        throw new UnsupportedOperationException("Member service is not supported");
    }
}
