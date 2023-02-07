package com.cbu.backend.studygroup;

import com.cbu.backend.member.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
    @Query(
            "SELECT l FROM StudyGroup sg, LikeMember l WHERE l.studyGroup.id = :id and l.member ="
                    + " :member")
    Optional<LikeMember> findLikeCountByIdAndMember(Long id, Member member);
}
