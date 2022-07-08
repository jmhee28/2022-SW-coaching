package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.post.Post;
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
  private final Long totalcnt;
  public Board(Long id, String title, String remark, List<Post> posts, Long totalcnt) {
    this.id = id;
    this.title = title;
    this.remark = remark;
    this.posts = posts;
    this.totalcnt = totalcnt;
  }

  public static Board of(BoardEntity boardEntity) {
    //Board Entity에서 board로, Entitiy는 db랑 연결되어 있는것
    List<Post> posts = boardEntity.getPosts()
            .stream().map(Post::of).collect(Collectors.toList());
    return new Board(boardEntity.getId(),
            boardEntity.getTitle(),
            boardEntity.getRemark(),
            posts, boardEntity.getTotalcnt());
  }
}