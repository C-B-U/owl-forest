package com.cbu.backend.boardcomment.service;

import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.service.BoardService;
import com.cbu.backend.boardcomment.dto.request.BoardCommentRequestDTO;
import com.cbu.backend.boardcomment.dto.request.UpdateBoardCommentRequestDTO;
import com.cbu.backend.boardcomment.dto.response.BoardCommentResponseDTO;
import com.cbu.backend.boardcomment.entity.BoardComment;
import com.cbu.backend.boardcomment.mapper.BoardCommentMapper;
import com.cbu.backend.boardcomment.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;
    private final BoardCommentMapper boardCommentMapper;

    private final BoardService boardService;

    public BoardCommentResponseDTO save(Long boardId, BoardCommentRequestDTO dto) {
        Board board = boardService.getEntity(boardId);
        BoardComment savedBoardComment =
                boardCommentRepository.save(boardCommentMapper.toEntity(dto, board));

        return boardCommentMapper.toDto(savedBoardComment);
    }

    public List<BoardCommentResponseDTO> getAllByBoardId(Long boardId) {
        return boardCommentRepository.findAllByBoardId(boardId)
                .stream()
                .map(boardCommentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public BoardCommentResponseDTO delete(Long id) {
        BoardComment boardComment = getEntity(id);
        boardComment.getBaseTime().delete();
        return boardCommentMapper.toDto(boardComment);
    }

    public BoardCommentResponseDTO update(Long id, UpdateBoardCommentRequestDTO dto) {
        BoardComment boardComment = getEntity(id);
        modifyBoardComment(boardComment, dto);

        return boardCommentMapper.toDto(boardComment);
    }

    private void modifyBoardComment(BoardComment boardComment, UpdateBoardCommentRequestDTO dto) {
        boardComment.setContent(dto.getContent());
    }

    private BoardComment getEntity(Long id) {
        return boardCommentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
