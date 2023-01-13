package com.cbu.backend.book.command.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Getter @EmbeddedId private BookNo id;

    @Builder
    public Book(BookNo id) {
        this.id = id;
    }
}
