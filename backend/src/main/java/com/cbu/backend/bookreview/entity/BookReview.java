package com.cbu.backend.bookreview.entity;


import com.cbu.backend.global.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private Long writerId;

    @Column(nullable = false)
    private String detailReview;

    @Column(nullable = false)
    private String simpleReview;

    @Column(nullable = false)
    private double starPoint;

    @Column(nullable = false)
    private double starLevel;

    @Embedded
    private BaseTime baseTime;

}
