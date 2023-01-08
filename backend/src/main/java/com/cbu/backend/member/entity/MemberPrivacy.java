package com.cbu.backend.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPrivacy {
  private String studentId;

  private String phoneNumber;
}
