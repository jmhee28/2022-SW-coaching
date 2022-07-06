package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Autowired
    private BoardRepository boardRepository;

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
    @Override
    @Transactional
    public long save(PostSaveRequestDto requestDto, Long id) {
        BoardEntity board = boardRepository.findById(id).orElseThrow(() -> new BoardNotFoundException(id));
        PostEntity p = requestDto.toEntity();
        p.setBoard(board);
        return postRepository.save(p).getId();
    }
    @Transactional
    @Override
    public void addviewcount(Long id)
    {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        post.addViewCount();
    }
}
