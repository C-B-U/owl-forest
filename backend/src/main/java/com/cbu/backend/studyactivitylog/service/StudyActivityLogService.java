package com.cbu.backend.studyactivitylog.service;

import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequestDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;
import com.cbu.backend.studyactivitylog.mapper.StudyActivityLogMapper;
import com.cbu.backend.studyactivitylog.repository.StudyActivityLogRepository;
import com.cbu.backend.studygroup.entity.StudyGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyActivityLogService {
    private final StudyActivityLogRepository studyActivityLogRepository;
    private final MemberService memberService;

    private final StudyActivityLogMapper studyActivityLogMapper;
    @Transactional
    public StudyActivityLogResponseDTO update(Long id, StudyActivityLogRequestDTO dto){
        StudyActivityLog studyActivityLog = getEntity(id);
        List<Member> members = new ArrayList<>();

        modifyStudyActivityLog(studyActivityLog,dto);


        return studyActivityLogMapper.toDto(studyActivityLog, members);
    }

    private StudyActivityLog getEntity(Long id){
        return studyActivityLogRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    private void modifyStudyActivityLog(StudyActivityLog studyActivityLog,StudyActivityLogRequestDTO dto){

        studyActivityLog.setAssignment(dto.getAssignment());
        studyActivityLog.setDescription(dto.getDescription());
        studyActivityLog.setPlace(dto.getPlace());
        studyActivityLog.setTitle(dto.getTitle());
        studyActivityLog.setEndTime(dto.getEndTime());
        studyActivityLog.setStartTime(dto.getStartTime());
    }
}
