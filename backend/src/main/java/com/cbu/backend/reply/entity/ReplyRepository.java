package com.cbu.backend.reply.entity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
  List<Reply> findByContentContaining(String keyword);
}
