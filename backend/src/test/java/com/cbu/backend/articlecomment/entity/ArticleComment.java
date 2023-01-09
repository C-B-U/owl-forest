package com.cbu.backend.articlecomment.entity;

import com.cbu.backend.article.entity.Article;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.entity.Member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleComment {
    @Id @GeneratedValue private Long id;

    @Setter
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @Embedded private BaseTime baseTime;

    @Builder
    public ArticleComment(String content, Member writer, Article article) {
        this.content = content;
        this.writer = writer;
        this.article = article;

        article.getComments().add(this);
    }
}
