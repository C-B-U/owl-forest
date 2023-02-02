package com.cbu.backend.authaccount.command.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInterest {
    @Column private String value;
}
