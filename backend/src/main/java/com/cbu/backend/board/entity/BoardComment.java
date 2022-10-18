package com.cbu.backend.board.entity;

import com.cbu.backend.global.BaseTime;

import javax.persistence.*;

@Entity
public class BoardComment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer; // TODO writer ID로 연결해야

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Embedded
    private BaseTime baseTime;
}
