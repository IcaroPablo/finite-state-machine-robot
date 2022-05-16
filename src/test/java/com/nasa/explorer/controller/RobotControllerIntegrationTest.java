package com.nasa.explorer.controller;

import com.nasa.explorer.exception.InvalidInstructionException;
import com.nasa.explorer.service.RobotService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import javax.validation.ConstraintViolationException;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RobotControllerIntegrationTest {

    @MockBean
    private RobotService robotService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("simple instructions must return end position to the endpoint")
    public void testFollowSimpleInstructions() throws Exception {

        when(robotService.follow("MML")).thenReturn("(0, 2, W)");
        mockMvc.perform(post("/rest/mars/MML"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("(0, 2, W)")));

    }

    @Test
    @DisplayName("bad instructions must return http status 400")
    public void testAvoidBadInstructions() throws Exception {

        when(robotService.follow("JKD")).thenThrow(ConstraintViolationException.class);
        mockMvc.perform(post("/rest/mars/JKD"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("400 Bad Request")));

    }

    @Test
    @DisplayName("bad sequence of correct instructions must return http status 400")
    public void testInterruptBadSequenceOfCorrectInstructions() throws Exception {

        when(robotService.follow("MMMMMMMMMMMMMR")).thenThrow(InvalidInstructionException.class);
        mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMR"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("400 Bad Request")));

    }

}
