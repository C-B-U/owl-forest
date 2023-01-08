package com.cbu.backend.reply.service;

import com.cbu.backend.reply.dto.ReplyRequest;
import com.cbu.backend.reply.dto.ReplyResponse;
import com.cbu.backend.reply.dto.UpdateReplyRequest;
import com.cbu.backend.reply.entity.Reply;
import com.cbu.backend.reply.entity.ReplyRepository;
import com.cbu.backend.reply.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;

    // 생성 기능
    public void create(ReplyRequest request) {
        Reply reply = replyMapper.mapToEntity(request);
        replyRepository.save(reply);
    }

    // 단일 조회 기능
    public ReplyResponse findById(Long id) {
        Reply result = replyRepository.findById(id).orElseThrow(EntityExistsException::new);
        return replyMapper.mapToDTO(result);
    }

    // 목록 조회 기능
    public List<ReplyResponse> findAllOld() {
        return replyRepository.findAll(Sort.by(Sort.Direction.ASC, "date")).stream()
                .map(replyMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    // 목록 조회 기능(최신순)
    public List<ReplyResponse> findAllRecent() {
        return replyRepository.findAll(Sort.by(Sort.Direction.DESC, "date")).stream()
                .map(replyMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    // 키워드로 검색
    @Transactional
    public List<ReplyResponse> findByKeywordContains(String keyword) {
        return replyRepository.findByContentContaining(keyword).stream()
                .map(replyMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    // 댓글 삭제
    public void deleteById(Long id) {
        replyRepository.deleteById(id);
    }

    // 댓글 수정
    @Transactional
    public void update(Long id, UpdateReplyRequest dto) {

        Reply reply =
                replyRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("댓글 수정 X"));
        reply.update(dto.getContent());
    }
}
