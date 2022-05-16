package com.nasa.explorer.service;

import com.nasa.explorer.exception.InvalidInstructionException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RobotServiceTest {

    @Autowired
    private RobotService robotService;

    @Test
    @DisplayName("simple instructions must be run flawlessly")
    public void testFollowSimpleInstructions() {

        assertEquals(robotService.follow("MML"), "(0, 2, W)");

    }

    @Test
    @DisplayName("bad instructions must be avoided")
    public void testAvoidBadInstructions() {

        assertEquals(robotService.follow("JKD"), "(0, 0, N)");

    }

    @Test
    @DisplayName("bad sequence of correct executions must throw an exception")
    public void testInterruptBadSequenceOfCorrectInstructions() {

        assertThrows(InvalidInstructionException.class, () -> robotService.follow("MMMMMMMMMMMMMR"));

    }

}
