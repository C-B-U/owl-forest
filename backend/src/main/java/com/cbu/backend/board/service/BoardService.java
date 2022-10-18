package com.cbu.backend.board.service;

import com.cbu.backend.board.dto.request.BoardRequestDTO;
import com.cbu.backend.board.dto.request.UpdateBoardRequestDTO;
import com.cbu.backend.board.dto.response.BoardResponseDTO;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.mapper.BoardMapper;
import com.cbu.backend.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Transactional
    public BoardResponseDTO save(BoardRequestDTO dto) {
        Board result = boardRepository.save(boardMapper.toEntity(dto));

        return boardMapper.toDto(result);
    }

    @Transactional
    public BoardResponseDTO update(Long id, UpdateBoardRequestDTO dto) {
        Board board = getBoardEntity(id);
        modifyBoard(board, dto);

        return boardMapper.toDto(board);
    }

    private void modifyBoard(Board board, UpdateBoardRequestDTO dto) {
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setIsPublic(dto.getIsPublic());
    }

    @Transactional
    public BoardResponseDTO delete(Long id) {
        Board board = getBoardEntity(id);
        board.getBaseTime().delete();

        return boardMapper.toDto(board);
    }

    public BoardResponseDTO get(Long id) {
        Board board = getBoardEntity(id);

        return boardMapper.toDto(board);
    }

    public List<BoardResponseDTO> getAll() {

        return boardRepository.findAll()
                .stream()
                .map(boardMapper::toDto)
                .collect(Collectors.toList());
    }

    private Board getBoardEntity(Long id) {

        return boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
