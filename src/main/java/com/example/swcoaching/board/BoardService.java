package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
  Board findById(long id);
  BoardEntity findEntityById(Long id);
  Long getBoardTotalCnt(Long id);
  List<BoardListResponseDto> findAllDesc();
  void AddBoard(BoardSaveRequestDto boardSaveRequestDto);
}