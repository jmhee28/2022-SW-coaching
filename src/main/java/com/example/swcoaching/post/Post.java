package com.example.swcoaching.post;

import com.example.swcoaching.post.jpa.PostEntity;
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

  private Long viewcount;
  public Post(Long id, String title, String contents, Long viewcount) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.viewcount = viewcount;
  }

  public static Post of(PostEntity postEntity) {

    return new Post(postEntity.getId(), postEntity.getTitle(), postEntity.getContents(), postEntity.getViewcount());
  }
}