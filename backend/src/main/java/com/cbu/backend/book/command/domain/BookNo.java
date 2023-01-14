package com.cbu.backend.book.command.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookNo implements Serializable {
    @Column(name = "book_id", columnDefinition = "uuid")
    private UUID id;

    private String isbn;

    public BookNo(String isbn) {
        this.id = UUID.randomUUID();
        this.isbn = isbn;
    }
}
