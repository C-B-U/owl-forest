package com.cbu.backend.studyactivitylog.command.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Embeddable
public class StudyActivityLogNo implements Serializable {

    @Column(name = "study_activity_log_id", columnDefinition = "BINARY(16)")
    private UUID id;

    protected StudyActivityLogNo() {
        this.id = UUID.randomUUID();
    }
}
