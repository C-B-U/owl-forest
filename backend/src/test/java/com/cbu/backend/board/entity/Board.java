package com.cbu.backend.board.entity;

import com.cbu.backend.global.BaseTime;
import com.cbu.backend.domain.member.entity.Member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    @Setter
    private String name;

    @Setter private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @Setter
    private Member manager;

    @Embedded private BaseTime baseTime;

    @Builder
    public Board(String name, String description, Member manager) {
        this.name = name;
        this.description = description;
        this.manager = manager;
    }
}
