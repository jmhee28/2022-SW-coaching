package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    // count method

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
        post.getBoard().MinusTotalCnt();
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
    public void save(PostSaveRequestDto requestDto, Long bid) {
        BoardEntity board = boardRepository.findById(bid).orElseThrow(() -> new BoardNotFoundException(bid));
        board.AddTotalCnt();
        PostEntity p = requestDto.toEntity();
        p.setBoard(board);
        p.ZeroViewCount();
        postRepository.save(p);
    }
    @Transactional
    @Override
    public Long addviewcount(Long id)
    {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        post.addViewCount();
        return post.getViewcount();
    }
    @Transactional
    @Override
    public Long getviewcount(Long id)
    {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return post.getViewcount();
    }
    @Transactional
    @Override
    public Long postsboardid(Long id)
    {
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return post.getBoard().getId();
    }
    @Transactional
    @Override
    public List<PostSearchDto> getSearchList(String type, String keyword){
        if(type.equals("title")==true)
        {
            return postRepository.findByTitle(keyword).stream().map(PostSearchDto::new).collect(Collectors.toList());
        }
        else if(type.equals("contents")==true)
        {
            return postRepository.findByContentsContaining(keyword).stream().map(PostSearchDto::new).collect(Collectors.toList());
        }
        else // author
        {
          return  postRepository.findByAuthor(keyword).stream().map(PostSearchDto::new).collect(Collectors.toList());
        }
        //boardRepository.findAllDesc().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
    }
}
