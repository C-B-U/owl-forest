package com.cbu.backend.studygroup.repository;

import com.cbu.backend.studygroup.entity.StudyGroup;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 스터디 그룹의 CRUD를 담당하는 레포지토리 클래스
 *
 * @author ohksj(김승진)
 */
@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

    @EntityGraph(attributePaths = {"studyGroupLeader", "studyGroupMembers"})
    Optional<StudyGroup> findById(Long id);
}
