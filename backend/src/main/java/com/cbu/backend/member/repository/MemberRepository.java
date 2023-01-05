package com.cbu.backend.member.repository;

import com.cbu.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccountId(String accountId);
    boolean existsByAccountId(String accountId);
    List<Member> findByName(String name);

    List<Member> findByGeneration(Integer generation);

    List<Member> findByMajor(String major);

    List<Member> findByGrade(Integer grade);

}