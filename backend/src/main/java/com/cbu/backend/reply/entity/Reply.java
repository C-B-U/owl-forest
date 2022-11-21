package com.cbu.backend.reply.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Reply {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String content;
    private String date;


    @Builder
    public Reply(Long id, String name, String content, String date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }

    public void update(String content) {
        this.content = content;
        this.date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }
}
