package com.cbu.backend.boardcomment.entity;

import com.cbu.backend.board.entity.Board;
import com.cbu.backend.global.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardComment {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer; // TODO writer ID로 연결해야

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Embedded
    private BaseTime baseTime;

    @Builder
    public BoardComment(String content, String writer, Board board) {
        this.content = content;
        this.writer = writer;
        this.board = board;
    }
}
