package com.haretche.romannumeral.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haretche.romannumeral.model.RomanNumeralResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Executes Spring Boot integration tests for RomanNumeralController
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(RomanNumeralController.class)
public class RomanNumeralControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Make request to /rommannumeral with a valid query param.
     * Then validate the response body and check that its status is 200.
     */
    @Test
    void romanNumeralTestValidInput() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query", "4");
        MvcResult result = mockMvc.perform(request).andReturn();
        ObjectMapper jacksonMapper = new ObjectMapper();
        String expected = jacksonMapper.writeValueAsString(new RomanNumeralResponse(4, "IV"));
        String actual = result.getResponse().getContentAsString();

        Assertions.assertEquals(jacksonMapper.readTree(expected), jacksonMapper.readTree(actual));
        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    /**
     * Make request to /rommannumeral with a query param that is outside of the supported range.
     * Then validate the response's error message and status code 400.
     */
    @Test
    void romanNumeralTestOutOfRange() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query", "5000");
        MvcResult result = mockMvc.perform(request).andReturn();
        String expected = RomanNumeralController.ERROR_QUERY_OUT_OF_RANGE;
        String actual = result.getResponse().getContentAsString();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(400, result.getResponse().getStatus());
    }

    /**
     * Make request to /rommannumeral with a query param that is not an integer.
     * Then validate the response's error message and status code 400.
     */
    @Test
    void romanNumeralTestInvalidInputString() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query", "not an int");
        MvcResult result = mockMvc.perform(request).andReturn();
        String expected = RomanNumeralController.ERROR_QUERY_NOT_INT;
        String actual = result.getResponse().getContentAsString();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(400, result.getResponse().getStatus());
    }


    /**
     * Make request to /rommannumeral without query string.
     * Then validate the response's error message and status code 400.
     */
    @Test
    void romanNumeralTestMissingParam() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral");
        MvcResult result = mockMvc.perform(request).andReturn();
        String expected = RomanNumeralController.ERROR_NO_QUERY;
        String actual = result.getResponse().getContentAsString();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(400, result.getResponse().getStatus());
    }
}
