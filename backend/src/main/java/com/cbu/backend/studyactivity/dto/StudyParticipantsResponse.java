package com.cbu.backend.studyactivity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyParticipantsResponse {
    private UUID id;
    private String name;
}
