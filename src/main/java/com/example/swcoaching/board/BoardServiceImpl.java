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
    //return brd.getTotalcnt();

    return Long.valueOf(brd.getPosts().size());// 잘못됨 다 가져옴 메모리 안좋음
    //데이터 증가함에 따라 문제 스레드 충돌 트래픽이나 데이터 수에 따라 다름 //테이블 따로// 큐에 넣고 갱신
    // 점차적으로 개선 언제 개선될지 모름
  }

  @Override
  @Transactional
  public void AddBoard(BoardSaveRequestDto boardSaveRequestDto)
  {
      boardRepository.save(boardSaveRequestDto.toEntity());
  }

}