package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class Board {
  private final Long id;

  private final String title;

  private final String remark;

  private final List<Post> posts;

  public Board(Long id, String title, String remark, List<Post> posts) {
    this.id = id;
    this.title = title;
    this.remark = remark;
    this.posts = posts;
  }

  public static Board of(BoardEntity boardEntity) {
    List<Post> posts = boardEntity.getPosts()
            .stream().map(Post::of).collect(Collectors.toList());
    return new Board(boardEntity.getId(),
            boardEntity.getTitle(),
            boardEntity.getRemark(),
            posts);
  }
}