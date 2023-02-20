package com.cbu.backend.global.audit;

public interface Auditable {
    BaseTime getBaseTime();

    void setBaseTime(BaseTime baseTime);
}
