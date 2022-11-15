package com.cbu.backend.studyactivitylog.service;

import com.cbu.backend.studyactivitylog.dto.request.StudyActivityLogRequestDTO;
import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;
import com.cbu.backend.studyactivitylog.mapper.StudyActivityLogMapper;
import com.cbu.backend.studyactivitylog.repository.StudyActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyActivityLogService {

    private final StudyActivityLogRepository studyActivityLogRepository;
    private final StudyActivityLogMapper studyActivityLogMapper;

    private final MemberService memberService;


    public StudyActivityLogResponseDTO registerStudyActivityLog(StudyActivityLogRequestDTO studyActivityLogRequestDTO) {
        StudyActivityLog studyActivityLog = studyActivityLogMapper.toEntity(studyActivityLogRequestDTO);
        StudyActivityLog result = studyActivityLogRepository.save(studyActivityLog);
        result.getTeamMembers();
        return studyActivityLogMapper.toDto(result,);
    }

    public StudyActivityLogResponseDTO searchById(Long studyActivityLogId){
        Optional<StudyActivityLog> studyActivityLog = studyActivityLogRepository.findById(studyActivityLogId);
        if(!studyActivityLog.isPresent()){
            throw new EntityNotFoundException();
        }
        return studyActivityLogMapper.toDto(studyActivityLog.get(), members);
    }

}
