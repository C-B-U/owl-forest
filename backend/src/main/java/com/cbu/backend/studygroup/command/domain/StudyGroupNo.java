package com.cbu.backend.studygroup.command.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
public class StudyGroupNo implements Serializable {

    @Column(name = "study_group_id", columnDefinition = "BINARY(16)")
    private UUID id;

    protected StudyGroupNo() {
        id = UUID.randomUUID();
    }
}
