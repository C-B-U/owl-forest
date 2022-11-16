package com.cbu.backend.member.dto.response;

import com.cbu.backend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponseDTO {

    private Long id;
    private String accountId;
    private String email;
    private String name;
    private String generation;
//    public MemberResponseDTO(Member target) {
//        this.email = target.getEmail();
//        this.accountId = target.getAccountId();
//        this.name = target.getName();
//        this.generation = target.getGeneration();
//    }
}