package com.example.swcoaching.board;

import java.util.List;

public interface BoardService {
  Board findById(long id);
  void insert_post(Post post, long id);

//  List<Post> showposts(long id);
}