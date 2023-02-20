package com.cbu.backend.global;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class BaseTime {
    @Setter
    private LocalDateTime createdAt;
    @Setter
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public void delete() {
        deletedAt = LocalDateTime.now();
    }
}
