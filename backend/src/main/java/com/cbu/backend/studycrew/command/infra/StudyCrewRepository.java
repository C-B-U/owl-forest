package com.cbu.backend.studycrew.command.infra;

import com.cbu.backend.studycrew.command.domain.StudyCrew;
import com.cbu.backend.studycrew.command.domain.StudyCrewNo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyCrewRepository extends JpaRepository<StudyCrew, StudyCrewNo> {}
