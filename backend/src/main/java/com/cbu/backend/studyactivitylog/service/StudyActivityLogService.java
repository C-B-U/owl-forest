package com.cbu.backend.studyactivitylog.service;

import com.cbu.backend.studyactivitylog.dto.response.StudyActivityLogResponseDTO;
import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;
import com.cbu.backend.studygroup.entity.StudyGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudyActivityLogService {

    // TODO 덤프 메소드입니다. 가장 최근 스터디 일지의 생성 시간을 반환하도록 추후 구현해주세요.

    public LocalDateTime searchLatestStudyActivityLogCreatedAt(StudyGroup studyGroup) {
        return null;
    }


    @Transactional
    public StudyActivityLogResponseDTO delete(Long id) {
        StudyActivityLog studyActivityLog;
        studyActivityLog.getStudyGroup().delete();
        return studyActivityLogMapper.toDto(studyActivityLog);
    }
}
