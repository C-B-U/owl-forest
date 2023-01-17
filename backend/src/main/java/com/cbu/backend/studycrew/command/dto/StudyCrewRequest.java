package com.cbu.backend.studycrew.command.dto;

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
public class StudyCrewRequest {
    @NotEmpty
    private String name;
    private String description;
    @NotEmpty
    private AccountNo studyCrewLeaderId;
    // 1인 스터디의 경우 빈 컬렉션
    private List<AccountNo> studyCrewParticipantIds = new ArrayList<>();
}
