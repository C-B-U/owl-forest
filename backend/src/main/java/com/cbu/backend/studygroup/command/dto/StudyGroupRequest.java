package com.cbu.backend.studygroup.command.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studygroup.command.domain.StudyGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupRequest {
    @NotEmpty private String name;
    private String description;
    @NotEmpty private AccountNo leader;

    @NotEmpty private List<AccountNo> participants = new ArrayList<>();

    public StudyGroup toEntity() {
        return StudyGroup.builder()
                .name(name)
                .description(description)
                .leaderId(leader)
                .participantIds(participants)
                .build();
    }
}
