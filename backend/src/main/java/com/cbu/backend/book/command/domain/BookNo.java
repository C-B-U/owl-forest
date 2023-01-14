package com.cbu.backend.book.command.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookNo implements Serializable {
    @Column(name = "book_id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String isbn;

    public BookNo(String isbn) {
        this.id = UUID.randomUUID();
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return id.toString() + "-" + isbn;
    }
}
