package com.cbu.backend.config.audit;

import com.cbu.backend.global.BaseTime;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {
    @PrePersist
    public void setCreatedAt(Auditable auditable) {
        BaseTime baseTime = auditable.getBaseTime();

        if (baseTime == null) {
            baseTime = new BaseTime();
        }
        baseTime.setCreatedAt(LocalDateTime.now());
        auditable.setBaseTime(baseTime);
    }

    @PreUpdate
    public void setUpdatedAt(Auditable auditable) {
        BaseTime baseTime = auditable.getBaseTime();
        baseTime.setUpdatedAt(LocalDateTime.now());
    }
}
