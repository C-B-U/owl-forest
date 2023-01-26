package com.cbu.backend.bookreview.query.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class Writer {
    private AccountNo id;
    private String nickname;

    @QueryProjection
    public Writer(AccountNo id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
