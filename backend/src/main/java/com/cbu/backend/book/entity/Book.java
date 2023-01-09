package com.cbu.backend.book.entity;

import com.cbu.backend.global.BaseTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String isbn;
    private BaseTime baseTime;
}