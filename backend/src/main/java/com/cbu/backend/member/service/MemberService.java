package com.cbu.backend.member.service;

import com.cbu.backend.member.dto.request.MemberSignupRequestDTO;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
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

    public Member getEntity(Long id) {
        throw new UnsupportedOperationException("Member service is not supported");
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public MemberResponseDTO signup(MemberSignupRequestDTO dto) {

        //유효성 검사
        memberRepository.findByAccountId(dto.getAccountId())
                .ifPresent(u -> {throw new EntityExistsException();});

        //폼 데이터를 dto로 받아서 member객체 생성 - 이렇게하지 말고  DTO클래스에서 toEntity메소드를 통해 객체를 생성하고 리턴해서 받아 쓰기
        Member createdMember = memberRepository.save(memberMapper.toEntity(dto ,passwordEncoder));
        return memberMapper.toDto(createdMember);
    }
}
