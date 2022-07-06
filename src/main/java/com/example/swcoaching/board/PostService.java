package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;

public interface PostService {
    Post findById(long id); // null이 아닌것을 알고 있어서
    void delete (long id);

    void update(long id, PostUpdateRequestDto requestDto);
    long save(PostSaveRequestDto requestDto, Long id);

    void addviewcount(Long id);
}
