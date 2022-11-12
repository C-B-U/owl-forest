package com.cbu.backend.studyactivitylog.mapper;

import com.cbu.backend.member.entity.Member;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequestDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyParticipantResponseDTO;
import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudyActivityLogMapper {

    public StudyActivityLog toEntity(StudyActivityLogRequestDTO dto) {
        return StudyActivityLog.builder()
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .place(dto.getPlace())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .assignment(dto.getAssignment())
                .build();
    }

    public StudyActivityLogResponseDTO toDto(StudyActivityLog entity, List<Member> members) {
        return StudyActivityLogResponseDTO.builder()
                .id(entity.getId())
                .week(entity.getWeek())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .place(entity.getPlace())
                .title(entity.getTitle())
                .teamMembers(toParticipantDtoList(members))
                .description(entity.getDescription())
                .assignment(entity.getAssignment())
                .build();
    }
    private List<StudyParticipantResponseDTO> toParticipantDtoList(List<Member> entities) {
        List<StudyParticipantResponseDTO> result = new ArrayList<>();

        for(int i =0 ; i< entities.size() ; i++) {
            StudyParticipantResponseDTO dto = toParticipantDto(entities.get(i));
            result.add(dto);
        }
        return result;

        //return entities.stream()
        //        .map(this::toParticipantDto)
        //        .collect(Collectors.toList());
    }

    private StudyParticipantResponseDTO toParticipantDto(Member member) {
        return StudyParticipantResponseDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .major(member.getMajor())
                .grade(member.getGrade())
                .profileUrl(member.getProfileUrl())
                .build();
    }
}
