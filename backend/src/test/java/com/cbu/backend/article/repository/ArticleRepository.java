package com.cbu.backend.article.repository;

import com.cbu.backend.article.entity.Article;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
  public List<Article> findAllByBoardId(Long boardId, Pageable pageable);
}
