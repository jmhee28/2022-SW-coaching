package com.example.swcoaching.controller;

import com.example.swcoaching.board.*;
import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
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

  @GetMapping("/board/list")
  public List<BoardListResponseDto> findAll() {
    return boardService.findAllDesc();
  }

  @PostMapping("/addboard")
  public void addBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto)
  {
    boardService.AddBoard(boardSaveRequestDto);
  }
}