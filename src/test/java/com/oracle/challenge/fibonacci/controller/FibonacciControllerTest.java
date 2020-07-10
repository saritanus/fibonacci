package com.oracle.challenge.fibonacci.controller;

import com.oracle.challenge.fibonacci.model.FibonacciResponse;
import com.oracle.challenge.fibonacci.service.FibonacciService;
import com.oracle.challenge.fibonacci.utility.ResultMatcher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void generateSeries10() throws Exception {
        String json="{\"elements\":10}";
        String resp="{\"fibonacci\":[0,1,1,2,3,5,8,13,21,34],\"sorted\":[34,8,2,0,21,13,5,3,1,1]}";
        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(MockMvcRequestBuilders.post("/fibonacci")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        resp,
                        true));

    }

    @Test
    public void generateSeries0() throws Exception {
        String json = "{\"elements\":0}";
        mockMvc.perform(MockMvcRequestBuilders.post("/fibonacci")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @Test
    public void generateSeries100() throws Exception {
        String json = "{\"elements\":100}";
        mockMvc.perform(MockMvcRequestBuilders.post("/fibonacci")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

    }
}