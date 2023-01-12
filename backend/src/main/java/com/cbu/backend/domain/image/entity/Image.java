package com.cbu.backend.domain.image.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {
    @Id @GeneratedValue private Long id;
}
