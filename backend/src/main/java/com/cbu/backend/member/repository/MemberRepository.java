package com.cbu.backend.member.repository;

import com.cbu.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccountId(String accountId); //null의 가능성때문에 Optional사용
    //save 메소드는 JpaRepository가 상속받는 CrudRepository에 정의되어 있음

}