package com.cbu.backend.member.service;

import com.cbu.backend.member.dto.request.MemberSignupRequest;
import com.cbu.backend.member.dto.response.MemberResponse;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import com.cbu.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final MemberMapper memberMapper;




    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public MemberResponse signup(MemberSignupRequest dto) {
        if(memberRepository.existsByAccountId(dto.getAccountId())) {
            throw new EntityExistsException();
        }
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Member createdMember = memberRepository.save(memberMapper.toEntity(dto));

        return memberMapper.toDto(createdMember);
    }
}
