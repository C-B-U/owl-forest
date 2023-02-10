package com.cbu.backend.member;

import com.cbu.backend.member.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByoAuth2InfoSocialId(String socialId);
}
