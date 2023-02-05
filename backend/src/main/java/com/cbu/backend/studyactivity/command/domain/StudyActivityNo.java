package com.cbu.backend.studyactivity.command.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
public class StudyActivityNo implements Serializable {

    @Column(name = "study_activity_id", columnDefinition = "BINARY(16)")
    private UUID id;

    public StudyActivityNo() {
        this.id = UUID.randomUUID();
    }
}
