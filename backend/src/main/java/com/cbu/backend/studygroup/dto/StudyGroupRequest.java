package com.cbu.backend.studygroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupRequest {
    @NotEmpty private String name;
    private String description;
    @NotEmpty private UUID leader;
    @NotEmpty private List<UUID> members = new ArrayList<>();
}
