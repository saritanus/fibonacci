package com.oracle.challenge.fibonacci.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.oracle.challenge.fibonacci.service.FibonacciService;
import com.oracle.challenge.fibonacci.utility.ResultMatcher;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(FibonacciController.class)
class FibonacciControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void generateSeries10() throws Exception {
		String json = "{\"elements\":10}";
		String resp = "{\"fibonacci\":[0,1,1,2,3,5,8,13,21,34],\"sorted\":[34,8,2,0,21,13,5,3,1,1]}";
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
	void generateSeries0() throws Exception {
		String json = "{\"elements\":0}";
		String expected = String.format("Number elements is less than minimum value %d. [%d]", FibonacciService.MIN_ELEMENTS, 0);
		final String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/fibonacci")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().is4xxClientError())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Assert.assertEquals(expected, contentAsString);
	}

	@Test
	void generateSeries100() throws Exception {
		String json = "{\"elements\":100}";
		String expected = String.format("Number elements is greater than maximum value %d. [%d]", FibonacciService.MAX_ELEMENTS, 100);
		final String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/fibonacci")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().is4xxClientError())
				.andReturn()
				.getResponse()
				.getContentAsString();
		Assert.assertEquals(expected, contentAsString);
	}
}
