package com.cbu.backend.studygroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

    //    @Query(name = "SELECT sg.likeCount FROM StudyGroup sg WHERE sg.id = :id and
    // sg.likeCount.member = :member")
    //    Optional<LikeCount> findLikeCountByIdAndMember(Long id, Member member);
}
