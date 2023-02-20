package com.cbu.backend.global.audit;

import org.hibernate.annotations.Where;

@Where(clause = "deleted_at is null")
public @interface SoftDeleteSupport {}
