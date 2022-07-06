package com.example.swcoaching.board.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Query("SELECT b FROM BoardEntity  b ORDER BY b.id ASC ")
    List<BoardEntity> findAllDesc();
}