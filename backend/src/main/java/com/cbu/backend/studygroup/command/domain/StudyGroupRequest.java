package com.cbu.backend.studygroup.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

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
