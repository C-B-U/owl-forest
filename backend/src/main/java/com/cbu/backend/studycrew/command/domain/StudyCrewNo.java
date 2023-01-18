package com.cbu.backend.studycrew.command.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
public class StudyCrewNo implements Serializable {

    @Column(name = "study_crew_id", columnDefinition = "BINARY(16)")
    private UUID id;

    protected StudyCrewNo() {
        id = UUID.randomUUID();
    }
}
