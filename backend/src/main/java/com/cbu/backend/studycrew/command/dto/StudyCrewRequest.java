package com.cbu.backend.studycrew.command.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studycrew.command.domain.StudyCrew;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyCrewRequest {
    @NotEmpty private String name;
    private String description;
    @NotEmpty private AccountNo leader;

    @NotEmpty
    private List<AccountNo> participants = new ArrayList<>();

    public StudyCrew toEntity() {
        return  StudyCrew.builder()
                .name(name)
                .description(description)
                .leaderId(leader)
                .participantIds(participants)
                .build();
    }
}
