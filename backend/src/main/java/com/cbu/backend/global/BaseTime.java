package com.cbu.backend.global;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Embeddable
public class BaseTime {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deleteAt;

    public void delete() {
        deleteAt = LocalDateTime.now();
    }
}
