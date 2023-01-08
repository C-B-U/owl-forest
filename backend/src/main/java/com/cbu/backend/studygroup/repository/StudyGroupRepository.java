package com.cbu.backend.studygroup.repository;

import com.cbu.backend.studygroup.entity.StudyGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {}
