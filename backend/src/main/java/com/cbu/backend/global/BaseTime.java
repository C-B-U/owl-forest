package com.cbu.backend.global;

import lombok.Getter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;

@Getter
@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate private LocalDateTime createdAt;
    @LastModifiedDate private LocalDateTime updatedAt;
    private LocalDateTime deleteAt;

    public void delete() {
        deleteAt = LocalDateTime.now();
    }
}
