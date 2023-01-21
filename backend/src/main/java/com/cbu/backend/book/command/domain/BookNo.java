package com.cbu.backend.book.command.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class BookNo implements Serializable {
    @Column(name = "book_id", columnDefinition = "BINARY(16)")
    private UUID id;

    public BookNo() {
        this.id = UUID.randomUUID();
    }
}
