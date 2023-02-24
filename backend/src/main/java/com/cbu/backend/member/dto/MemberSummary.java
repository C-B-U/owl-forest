package com.cbu.backend.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class MemberSummary {
    private UUID id;
    private String name;
}
