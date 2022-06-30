package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) { this.postRepository = postRepository;}
        @Override
        @Transactional(readOnly = true)
        public Post findById(long id) {
            return postRepository.findById(id)
                    .map(Post::of)
                    .orElseThrow(() -> new BoardNotFoundException(id));
        }
    @Override
    @Transactional
    public void delete(long id)
    {
        PostEntity post = postRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postRepository.delete(post);
    }
    @Override
    @Transactional
    public void update(long id, PostUpdateRequestDto requestDto)
    {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        post.update(requestDto.getTitle(), requestDto.getContent());

    }

    @Transactional
    public long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

}
