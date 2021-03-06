package com.example.swcoaching.controller;

import com.example.swcoaching.board.*;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.example.swcoaching.board.PostSaveRequestDto;
import com.example.swcoaching.board.PostUpdateRequestDto;
import com.example.swcoaching.board.jpa.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    @DisplayName("show posts")
    @Test
    @WithMockUser(roles="USER")
    void getPost() throws Exception{
        mockMvc.perform(get("/post/{postId}", 2))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(is(2)));
    }
    @Test
    @WithMockUser(roles="USER")
    void deletePost() throws Exception{
        mockMvc.perform(get("/deletePost/{postId}", 1))
                .andDo(print());

    }
    @Test
    @WithMockUser(roles="USER")
    void updatePost() throws Exception{



        Long updateId = 2L;
        String expectedTitle = "title2";
        String expectedContent = "content2";

        PostUpdateRequestDto requestDto = new PostUpdateRequestDto(expectedTitle,expectedContent );


        mockMvc.perform(put("/updatePosts/{id}", 2).contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)));
    }
//    @Test
//    @WithMockUser(roles="USER")
//    void savePost() throws Exception{
//        String title = "titlqwee";
//        String contents = "content";
//        long id =1;
//        //oardEntity brd = boardRepository.findById(1L) .orElseThrow(() -> new BoardNotFoundException(id));
//
//        PostSaveRequestDto requestDto = new PostSaveRequestDto (title, contents,id);
//
//        mockMvc.perform(post("/savePosts/{bid}", 1)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//    }
    @Test
    void addcount() throws Exception{
        mockMvc.perform(put("/addViewCount/{id}", 17));

    }
}
