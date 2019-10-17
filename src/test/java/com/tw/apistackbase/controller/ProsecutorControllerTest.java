package com.tw.apistackbase.controller;

import antlr.build.Tool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.entity.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProsecutorController.class)
@ActiveProfiles(profiles = "test")
class ProsecutorControllerTest {
    @MockBean
    private ProsecutorRepo prosecutorRepository;

    private List<Prosecutor> prosecutors = new ArrayList<>();

    private Prosecutor prosecutor;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_return_prosecutors() throws Exception {
        when(prosecutorRepository.findAll()).thenReturn(prosecutors);

        ResultActions result = mvc.perform(get("/api/prosecutors"));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").value(prosecutors));
    }

    @Test
    void should_add_prosecutor() throws Exception {
        prosecutor = new Prosecutor();
        ResultActions result = mvc.perform(post("/api/prosecutors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(prosecutor)));
        result.andExpect(status().isCreated());
    }
}