package com.example.swcoaching.controller;

import com.example.swcoaching.board.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final PostService postService;


    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable long postId) {
        Post post = postService.findById(postId);
        logger.info("post: {}", post);
        return post;
    }
    @GetMapping("/deletePost/{postId}")
    public void deletePost(@PathVariable long postId) {
        postService.delete(postId);

    }
    @PutMapping("/updatePosts/{id}")
    public void update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
       postService.update(id, requestDto);
    }
    @PostMapping("/savePosts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }


}

