package com.cbu.backend.bookreview.command.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Getter
@Embeddable
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BookReviewNo implements Serializable {
    @Column(name = "book_review_id", columnDefinition = "BINARY(16)")
    private UUID id;

    public BookReviewNo() {
        id = UUID.randomUUID();
    }
}
