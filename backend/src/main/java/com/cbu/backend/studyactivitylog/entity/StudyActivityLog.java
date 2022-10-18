package com.cbu.backend.studyactivitylog.entity;

import com.cbu.backend.studygroup.entity.StudyGroup;

import javax.persistence.*;

@Entity
public class StudyActivityLog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private StudyGroup studyGroup;
}
