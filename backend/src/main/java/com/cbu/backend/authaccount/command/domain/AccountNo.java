package com.cbu.backend.authaccount.command.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountNo implements Serializable {
    @Column(name = "account_id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String socialId;

    public AccountNo(String socialId) {
        this.id = UUID.randomUUID();
        this.socialId = socialId;
    }
}
