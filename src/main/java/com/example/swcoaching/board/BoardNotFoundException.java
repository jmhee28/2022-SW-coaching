package com.example.swcoaching.board;

public class BoardNotFoundException extends RuntimeException{
  public BoardNotFoundException(long id) {
    super(String.format("(%s)의 게시물을 찾을 수 없습니다.", id));
  }
}