package com.cbu.backend.member.service;

import com.cbu.backend.member.dto.request.MemberSignupRequest;
import com.cbu.backend.member.dto.response.MemberResponse;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import com.cbu.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final MemberMapper memberMapper;

    @Transactional
    public Member signup(MemberSignupRequest dto) {
        if(memberRepository.existsByAccountId(dto.getAccountId())) {
            throw new EntityExistsException();
        }
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Member createdMember = memberRepository.save(memberMapper.toEntity(dto));
        return createdMember;
    }

    public Member getEntity(Long id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public MemberResponse findById(Long id ) {
        return memberMapper.toDto(memberRepository.findById(id).orElseThrow((EntityNotFoundException::new)));
    }

    public MemberResponse findByAccountId(String accountId) {
        return memberMapper.toDto(memberRepository.findByAccountId(accountId).orElseThrow((EntityNotFoundException::new)));
    }

    public List<MemberResponse> findByName(String name) {

        return memberMapper.toDtoList(memberRepository.findByName(name));
    }

    public List<MemberResponse> findByGeneration(int generation) {

        return memberMapper.toDtoList(memberRepository.findByGeneration(generation));
    }

    public List<MemberResponse> findByMajor(String major) {

        return memberMapper.toDtoList(memberRepository.findByMajor(major));
    }

    public List<MemberResponse> findByGrade(int grade) {

        return memberMapper.toDtoList(memberRepository.findByGrade(grade));
    }
}