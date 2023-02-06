package com.cbu.backend.studygroup;

import com.cbu.backend.member.domain.Member;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

//    @Query(name = "SELECT sg.likeCount FROM StudyGroup sg WHERE sg.id = :id and sg.likeCount.member = :member")
//    Optional<LikeCount> findLikeCountByIdAndMember(Long id, Member member);
}