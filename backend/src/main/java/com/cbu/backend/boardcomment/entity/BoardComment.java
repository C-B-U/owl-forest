package com.cbu.backend.boardcomment.entity;

import com.cbu.backend.board.entity.Board;
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

    public BoardComment(String content, String writer, Board board) {
        this.content = content;
        this.writer = writer;
        this.board = board;
    }
}
