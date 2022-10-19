package com.cbu.backend.boardcomment.repository;

import com.cbu.backend.boardcomment.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
    List<BoardComment> findAllByBoardId(Long boardId);
}
