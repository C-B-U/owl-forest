package com.cbu.backend.boardsubscribe.entity;

import com.cbu.backend.board.entity.Board;
import com.cbu.backend.domain.member.entity.Member;
import com.cbu.backend.global.BaseTime;

import lombok.Builder;

import javax.persistence.*;

@Entity
public class BoardSubscribe {

    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Embedded private BaseTime baseTime;

    @Builder
    public BoardSubscribe(Board board, Member member) {
        this.board = board;
        this.member = member;
    }
}
