package com.cbu.backend.boardsubscribe.repository;

import com.cbu.backend.boardsubscribe.entity.BoardSubscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardSubscribeRepository extends JpaRepository<BoardSubscribe, Long> {}
