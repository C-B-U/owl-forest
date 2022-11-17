package com.cbu.backend.studyactivitylog.service;

import com.cbu.backend.member.entity.Member;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequest;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponse;
import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;
import com.cbu.backend.studyactivitylog.entity.StudyParticipant;
import com.cbu.backend.studyactivitylog.mapper.StudyActivityLogMapper;
import com.cbu.backend.studyactivitylog.repository.StudyActivityLogRepository;
import com.cbu.backend.studygroup.entity.StudyGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyActivityLogService {

    private final StudyActivityLogRepository studyActivityLogRepository;
    private final StudyActivityLogMapper studyActivityLogMapper;

    public StudyActivityLogResponse registerStudyActivityLog(Long groupId, StudyActivityLogRequest studyActivityLogRequestDTO) {
        StudyActivityLog studyActivityLog = studyActivityLogMapper.toEntity(studyActivityLogRequestDTO);
        StudyActivityLog result = studyActivityLogRepository.save(studyActivityLog);
        //List<Member> teamMembers = result.getTeamMembers().stream()
          //      .map(StudyParticipant::getMember)
            //    .collect(Collectors.toList());

        List<StudyParticipant> resultTeamMembers = result.getTeamMembers();
        List<Member> members = new ArrayList<>();
        for(StudyParticipant sp : resultTeamMembers) {
            members.add(sp.getMember());
        }

        return studyActivityLogMapper.toDto(result,members);
    }

    public StudyActivityLogResponse searchById(Long studyActivityLogId){
        StudyActivityLog studyActivityLog = studyActivityLogRepository.findById(studyActivityLogId)
                .orElseThrow(EntityNotFoundException::new);

        List<Member> teamMembers = studyActivityLog.getTeamMembers().stream()
                .map(StudyParticipant::getMember)
                .collect(Collectors.toList());

        return studyActivityLogMapper.toDto(studyActivityLog, teamMembers);
    }

    public LocalDateTime searchLatestStudyActivityLogCreatedAt(StudyGroup studyGroup) {
        return null;
    }

}
