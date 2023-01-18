package com.cbu.backend.authaccount.command.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Getter
@Embeddable
public class AccountNo implements Serializable {
    @Column(name = "account_id", columnDefinition = "BINARY(16)")
    private UUID id;

    public AccountNo() {
        this.id = UUID.randomUUID();
    }
}
