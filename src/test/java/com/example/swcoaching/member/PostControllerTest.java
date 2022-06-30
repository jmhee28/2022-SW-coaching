package com.example.swcoaching.member;

import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.PostSaveRequestDto;
import com.example.swcoaching.board.jpa.PostEntity;
import com.example.swcoaching.board.jpa.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PostRepository postRepository;
    @DisplayName("show posts")
    @Test

    void getPost() throws Exception{
        mockMvc.perform(get("/post/{postId}", 2))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(is(2)));
    }
    @Test
    void deletePost() throws Exception{
        mockMvc.perform(get("/deletePost/{postId}", 1))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(is(1)));
    }
//    @Test
//    void updatePost() throws Exception{
//
//        Post savedPosts = postRepository.save(Post.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//        mockMvc.perform("/updatePosts/{id}", 1)
//    }
    @Test
    void savePost() throws Exception{
        String title = "title";
        String contents = "content";
        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .title(title)
                .contents(contents)
                .id(10L)
                .build();
        mockMvc.perform(post("/savePosts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

    }
}
