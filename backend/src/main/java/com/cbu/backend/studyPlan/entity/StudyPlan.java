package com.cbu.backend.studyPlan.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StudyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
