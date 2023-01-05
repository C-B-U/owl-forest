package com.cbu.backend.boardsubscribe.entity;

import com.cbu.backend.board.entity.Board;
import com.cbu.backend.global.BaseTime;
import com.cbu.backend.member.entity.Member;
import javax.persistence.*;
import lombok.Builder;

@Entity
public class BoardSubscribe {

  @Id @GeneratedValue private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id", nullable = false)
  private Board board;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  @Embedded private BaseTime baseTime;

  @Builder
  public BoardSubscribe(Board board, Member member) {
    this.board = board;
    this.member = member;
  }
}
