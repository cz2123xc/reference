package com.example.reference.api.controller;

import com.example.reference.api.domain.Post;
import com.example.reference.api.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
//@Transactional
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void clean() {
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("/post 요청시 Hello World! 반환 성공")
    void test() throws Exception {

        // excepted
        mockMvc.perform(post("/posts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\":\"Hello World!\", \"content\":\"내용 입니다.\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("{}"))
                .andDo(print());
    }

    @Test
    @DisplayName("/post 요청시 title 값은 필수다.")
    void test2() throws Exception {

        // when
        mockMvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"제목입니다.\", \"content\":\"내용 입니다.\"}")
        )
                .andExpect(status().isOk())
                .andDo(print());

        // then
        assertEquals(1L, postRepository.count());

        Post post = postRepository.findAll().get(0);

        assertEquals("제목입니다.", post.getTitle());
        assertEquals("내용 입니다.", post.getContent());

    }







}