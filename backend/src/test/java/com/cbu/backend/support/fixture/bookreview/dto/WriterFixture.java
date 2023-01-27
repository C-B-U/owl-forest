package com.cbu.backend.support.fixture.bookreview.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.bookreview.query.dto.Writer;

public enum WriterFixture {
    SAMPLE1(new AccountNo(), "해리 포터"),
    SAMPLE2(new AccountNo(), "헤르미온느");
    private final AccountNo id;
    private final String nickname;

    WriterFixture(AccountNo id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Writer toWriter() {
        return new Writer(this.id, this.nickname);
    }
}
