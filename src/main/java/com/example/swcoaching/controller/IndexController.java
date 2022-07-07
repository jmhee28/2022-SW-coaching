package com.example.swcoaching.controller;

import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.PostResponseDto;
import com.example.swcoaching.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    private final BoardService boardService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("board", boardService.findAllDesc());
        return "index";
    }
    @GetMapping("/board/posts/{id}")
    public String showboardposts(@PathVariable Long id,Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "boardposts";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
    
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        Post p = postService.findById(id);
        PostResponseDto dto = new PostResponseDto(p);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    @GetMapping("posts/addViewCount/{id}")
    public String addcount(@PathVariable Long id) {
        postService.addviewcount(id);
        return "boardposts";
    }
}
