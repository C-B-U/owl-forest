package com.cbu.backend.service;

import com.cbu.backend.dto.ReplyRequest;
import com.cbu.backend.dto.ReplyResponse;
import com.cbu.backend.dto.ReplyUpdateRequest;
import com.cbu.backend.entity.Reply;
import com.cbu.backend.entity.ReplyRepository;
import com.cbu.backend.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;

    //생성 기능
    public void create(ReplyRequest request) {
        Reply reply = replyMapper.mapToEntity(request);
        replyRepository.save(reply);
    }

    //단일 조회 기능
    public ReplyResponse getById(Long id) {
        Reply result = replyRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return replyMapper.mapToDTO(result);
    }


    //목록 조회 기능
    public List<ReplyResponse> getAllOld(){
        return replyRepository.findAll(Sort.by(Sort.Direction.ASC,"date"))
                .stream()
                .map(replyMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //목록 조회 기능(최신순)
    public List<ReplyResponse> getAllRecent(){
        return replyRepository.findAll(Sort.by(Sort.Direction.DESC,"date"))
                .stream()
                .map(replyMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //키워드로 검색
    @Transactional
    public List<ReplyResponse> getByKeyword(String keyword){
        return replyRepository.findByContentContaining(keyword)
                .stream()
                .map(replyMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    //댓글 삭제
    public void deleteById(Long id) {
        replyRepository.deleteById(id);
    }

    //댓글 수정
    @Transactional
    public void update(Long id , ReplyUpdateRequest dto){

        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 X"));
        reply.update(dto.getContent());

    }

}

