package com.cbu.backend.member.entity;

import javax.persistence.Embeddable;

@Embeddable
public class MemberPrivacy {
    private String studentId;

    private String phoneNumber;
}
