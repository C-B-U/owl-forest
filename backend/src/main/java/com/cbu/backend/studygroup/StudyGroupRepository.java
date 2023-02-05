package com.cbu.backend.studygroup;

import com.cbu.backend.authaccount.command.domain.Member;
import com.cbu.backend.studygroup.dto.StudyGroupProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
    Optional<LikeCount> findLikeCountByStudyGroupIdAndMember(Long id, Member member);

    Optional<StudyGroupProjection> findResponseById(Long id);

    List<StudyGroupProjection> findAllResponse(Pageable pageable);
}
