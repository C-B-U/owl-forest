package com.cbu.backend.config.audit;

import com.cbu.backend.global.BaseTime;

public interface Auditable {
    BaseTime getBaseTime();
    void setBaseTime(BaseTime baseTime);
}
