package com.example.swcoaching.board;

public interface PostService {
    Post findById(long id);
    void delete (long id);

    void update(long id, PostUpdateRequestDto requestDto);
    long save(PostSaveRequestDto requestDto);
}
