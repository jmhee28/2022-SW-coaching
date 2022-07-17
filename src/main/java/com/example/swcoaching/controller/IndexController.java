package com.example.swcoaching.controller;

import com.example.swcoaching.board.BoardService;
import com.example.swcoaching.config.auth.LoginUser;
import com.example.swcoaching.config.auth.dto.SessionUser;
import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.PostResponseDto;
import com.example.swcoaching.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    private final BoardService boardService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("board", boardService.findAllDesc());

       // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/board/posts/{id}")
    public String showboardposts(@PathVariable Long id,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("board", boardService.findById(id));

        return "boardposts";
    }

    @GetMapping("/posts/save/{bid}")
    public String postsSave(@PathVariable Long bid, Model model, @LoginUser SessionUser user) {
        model.addAttribute("bid", bid);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts-save";
    }
    @GetMapping("/indexposts/save/")
    public String IndexpostsSave(Model model,@LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "save";
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
        Long board_id = postService.postsboardid(id);
        String url = "/board/posts/"+board_id.toString();
        return "redirect:"+ url;

    }
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Long board_id = postService.postsboardid(id);
        postService.delete(id);

        String url = "/board/posts/"+board_id.toString();
        return "redirect:"+ url;

    }
    @GetMapping("/board/save/")
    public String AddBoard()
    {
        return "board-save";
    }

    @GetMapping("/posts/show/{id}")
    public String showPost(@PathVariable long id, Model model) {
        postService.addviewcount(id);
        Post p = postService.findById(id);
        PostResponseDto dto = new PostResponseDto(p);
        model.addAttribute("post", dto);
        return "viewpost";

    }
}
