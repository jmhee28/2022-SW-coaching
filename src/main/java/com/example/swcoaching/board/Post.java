package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;
import lombok.Getter;
import lombok.ToString;

/**
 * 게시물 Dto
 */
@ToString
@Getter
public class Post {
  private final Long id;

  private final String title;

  private final String contents;


  public Post(Long id, String title, String contents
  ) {
    this.id = id;

    this.title = title;
    this.contents = contents;
  }

  public static Post of(PostEntity postEntity) {

    return new Post(postEntity.getId(), postEntity.getTitle(), postEntity.getContents());
  }
}