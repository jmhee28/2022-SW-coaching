package com.example.swcoaching.controller;

import com.example.swcoaching.board.Board;
import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.jpa.BoardRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping

public class BoardController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final BoardService boardService;

  @GetMapping("/board/{boardId}")
  public Board getBoard(@PathVariable long boardId) {
    Board board = boardService.findById(boardId);
    logger.info("Board: {}", board);
    return board;
  }
  @PostMapping("/board/{boardId}/insert")
  public void insert_post(@PathVariable long boardId, Post post) {
    boardService.insert_post(post, boardId);
  }


}