package com.cbu.backend.member.entity;

import com.cbu.backend.image.entity.Image;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String nickname;

  @Embedded MemberDetail memberDetail = new MemberDetail();

  @Embedded MemberPrivacy memberPrivacy = new MemberPrivacy();

  @OneToOne private Image profileImage;

  @Builder
  public Member(String name, String nickname, MemberDetail memberDetail, MemberPrivacy memberPrivacy, Image profileImage) {
    this.name = name;
    this.nickname = nickname;
    this.memberDetail = memberDetail;
    this.memberPrivacy = memberPrivacy;
    this.profileImage = profileImage;
  }
}
