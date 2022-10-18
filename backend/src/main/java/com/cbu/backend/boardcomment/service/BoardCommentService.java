package com.cbu.backend.boardcomment.service;

import com.cbu.backend.boardcomment.dto.request.BoardCommentRequestDTO;
import com.cbu.backend.boardcomment.dto.response.BoardCommentResponseDTO;
import com.cbu.backend.boardcomment.entity.BoardComment;
import com.cbu.backend.boardcomment.mapper.BoardCommentMapper;
import com.cbu.backend.boardcomment.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;
    private final BoardCommentMapper boardCommentMapper;

    public BoardCommentResponseDTO save(BoardCommentRequestDTO dto) {
        //boardCommentMapper
        //boardCommentRepository.save()
        return null;
    }

    public BoardCommentResponseDTO get(Long id) {
        return null;
    }

    public BoardCommentResponseDTO delete(Long id) {
        return null;
    }

    public BoardCommentResponseDTO update(Long id, BoardComment boardComment) {
        return null;
    }
}
