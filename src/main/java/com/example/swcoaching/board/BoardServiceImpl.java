package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;
  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }



  @Override
  @Transactional(readOnly = true)
  public BoardEntity findEntityById(Long id)
  {
    return boardRepository.findById(id)
                        .orElseThrow(() -> new BoardNotFoundException(id));
  }
  @Override
  @Transactional(readOnly = true)
  public Board findById(long id) {
    return boardRepository.findById(id)
            .map(Board::of)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }

  @Override
  @Transactional
  public List<BoardListResponseDto> findAllDesc()
  {
     return boardRepository.findAllDesc().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
  }
  @Override
  @Transactional
  public Long getBoardTotalCnt(Long id)
  {
    BoardEntity brd = boardRepository.findById(id).orElseThrow(() -> new BoardNotFoundException(id));
    return brd.getTotalcnt();
    //return Long.valueOf(brd.getPosts().size());
  }

  @Override
  @Transactional
  public void AddBoard(BoardSaveRequestDto boardSaveRequestDto)
  {
      boardRepository.save(boardSaveRequestDto.toEntity());
  }

}