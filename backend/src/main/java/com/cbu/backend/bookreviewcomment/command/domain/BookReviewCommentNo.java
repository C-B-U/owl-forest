package com.cbu.backend.bookreviewcomment.command.domain;

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
public class BookReviewCommentNo implements Serializable {
    @Column(name = "book_review_comment_id", columnDefinition = "BINARY(16)")
    private UUID id;

    public BookReviewCommentNo(String id) {
        this.id = UUID.fromString(id);
    }

    public BookReviewCommentNo() {
        id = UUID.randomUUID();
    }
}
