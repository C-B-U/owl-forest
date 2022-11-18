package com.cbu.backend.board.service;

import com.cbu.backend.board.dto.request.BoardRequest;
import com.cbu.backend.board.dto.request.UpdateBoardRequest;
import com.cbu.backend.board.dto.response.BoardResponse;
import com.cbu.backend.board.entity.Board;
import com.cbu.backend.board.mapper.BoardMapper;
import com.cbu.backend.board.repository.BoardRepository;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    private final MemberService memberService;

    @Transactional
    public BoardResponse create(BoardRequest dto) {
        Member manager = memberService.findById(dto.getManagerId());
        Board result = boardRepository.save(boardMapper.toEntity(dto, manager));

        return boardMapper.toDto(result);
    }

    @Transactional
    public BoardResponse updateById(Long id, UpdateBoardRequest dto) {
        Board board = getEntity(id);
        modifyBoard(board, dto);

        return boardMapper.toDto(board);
    }

    private void modifyBoard(Board board, UpdateBoardRequest dto) {
        Member manager = memberService.findById(dto.getMangerId());

        board.setName(dto.getName());
        board.setDescription(dto.getDescription());
        board.setManager(manager);
    }

    @Transactional
    public BoardResponse deleteById(Long id) {
        Board board = getEntity(id);
        board.getBaseTime().delete();

        return boardMapper.toDto(board);
    }

    public BoardResponse findById(Long id) {
        Board board = getEntity(id);

        return boardMapper.toDto(board);
    }

    public List<BoardResponse> getAll(Pageable pageable) {

        return boardRepository.findAll(pageable)
                .stream()
                .map(boardMapper::toDto)
                .collect(Collectors.toList());
    }

    public Board getEntity(Long id) {

        return boardRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
