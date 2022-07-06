package com.example.swcoaching.member;

import com.example.swcoaching.board.Post;
import com.example.swcoaching.board.PostSaveRequestDto;
import com.example.swcoaching.board.jpa.BoardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {
  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @DisplayName("게시판을 조회 한다")
  @Test
  void getMember() throws Exception {
    mockMvc.perform(get("/board/{boardId}", 1))
            .andDo(print())
            .andExpect(jsonPath("$.id").value(is(1)));
  }
  @Test
  void findAll() throws Exception {

    mockMvc.perform(get("/board/list")).andDo(print());
  }


}