package com.cbu.backend.article.entity;

import com.cbu.backend.articlecomment.entity.ArticleComment;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Column(nullable = false)
    @Setter
    private String title;

    @Lob
    @Column(nullable = false)
    @Setter
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member author;


    @Column(nullable = false)
    @Setter
    private Boolean isPublic;

    @OneToMany(mappedBy = "article")
    private List<ArticleComment> comments = new ArrayList<>();

    @Embedded
    private BaseTime baseTime;

    @Builder
    public Article(Board board, String title, String content, Member author, Boolean isPublic) {
        this.board = board;
        this.title = title;
        this.content = content;
        this.author = author;
        this.isPublic = isPublic;
    }
}
