package com.cbu.backend.board.entity;

import com.cbu.backend.global.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Setter
    private String title;

    @Lob
    @Column(nullable = false)
    @Setter
    private String content;

    @Column(nullable = false)
    private String writer; // TODO Member 클래스로 변경해야

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column(nullable = false)
    @Setter
    private Boolean isPublic;

    @OneToMany(mappedBy = "board")
    private List<BoardComment> comments = new ArrayList<>();

    @Embedded
    private BaseTime baseTime;

    @Builder
    public Board(String title, String content, String writer, BoardType boardType, boolean isPublic) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardType = boardType;
        this.isPublic = isPublic;
    }
}
