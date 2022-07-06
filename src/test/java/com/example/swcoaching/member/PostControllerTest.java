package com.example.swcoaching.member;

import com.example.swcoaching.board.*;
import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.jpa.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;
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
                .andDo(print());

    }
    @Test
    void updatePost() throws Exception{



        Long updateId = 2L;
        String expectedTitle = "title2";
        String expectedContent = "content2";

        PostUpdateRequestDto requestDto = new PostUpdateRequestDto(expectedTitle,expectedContent );


        mockMvc.perform(put("/updatePosts/{id}", 2).contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)));
    }
    @Test
    void savePost() throws Exception{
        String title = "title";
        String contents = "content";
        long id = 19;
        //oardEntity brd = boardRepository.findById(1L) .orElseThrow(() -> new BoardNotFoundException(id));

        PostSaveRequestDto requestDto = new PostSaveRequestDto (title, contents,id);

        mockMvc.perform(post("/savePosts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

    }
    @Test
    void addcount() throws Exception{
        mockMvc.perform(put("/addViewCount/{id}", 17));

    }
}
