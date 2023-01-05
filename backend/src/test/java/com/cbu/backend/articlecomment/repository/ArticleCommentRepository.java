package com.cbu.backend.articlecomment.repository;

import com.cbu.backend.articlecomment.entity.ArticleComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
  List<ArticleComment> findAllByArticleId(Long articleId);
}
