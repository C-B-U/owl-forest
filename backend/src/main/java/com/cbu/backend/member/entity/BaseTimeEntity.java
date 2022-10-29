package com.cbu.backend.member.entity;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Optional;

@Embeddable
public class BaseTimeEntity {
    @Getter
    private LocalDateTime createdAt;
    @Getter
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Boolean isDeleted() {
        return Optional.ofNullable(deletedAt).isPresent();

    }

    public BaseTimeEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

    public void update() {
        this.updatedAt = LocalDateTime.now();

    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }
}
