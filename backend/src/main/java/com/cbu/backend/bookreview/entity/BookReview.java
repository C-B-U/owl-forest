package com.cbu.backend.bookreview.entity;


import com.cbu.backend.book.entity.Book;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.entity.Member;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EnableJpaAuditing
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member writer;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false)
    private String review;

    @Setter
    @Column(nullable = false)
    private double star;

    @Setter
    @Column(nullable = false)
    private double level;

    @Setter
    @Column(nullable = false)
    private Boolean like;

    @Embedded
    private BaseTime baseTime;

}
