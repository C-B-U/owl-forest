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
    @Column(columnDefinition = "uuid")
    private UUID id;

    public BookNo(UUID id) {
        this.id = id;
    }
}
