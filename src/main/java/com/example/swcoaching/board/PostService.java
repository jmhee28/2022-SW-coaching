package com.example.swcoaching.board;

public interface PostService {
    Post findById(long id); // null이 아닌것을 알고 있어서
    void delete (long id);

    void update(long id, PostUpdateRequestDto requestDto);
    void save(PostSaveRequestDto requestDto, Long bid);

    Long addviewcount(Long id);

    Long getviewcount(Long id);

    Long postsboardid(Long id);
}
