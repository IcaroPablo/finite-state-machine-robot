package com.nasa.explorer.controller;

import com.nasa.explorer.exception.InvalidInstructionException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RobotControllerUnitTest {

    @Autowired
    private RobotController robotController;

    @Test
    @DisplayName("simple instructions must return end position to the endpoint")
    public void testFollowSimpleInstructions() {

        assertEquals(robotController.followInstructions("MML"), ResponseEntity.status(HttpStatus.OK).body("(0, 2, W)"));

    }

    @Test
    @DisplayName("bad instructions must must throw a ConstraintViolationException")
    public void testAvoidBadInstructions() throws Exception {

        assertThrows(ConstraintViolationException.class, () -> robotController.followInstructions("JKD"));

    }

    @Test
    @DisplayName("bad sequence of correct executions must throw an InvalidInstructionException")
    public void testInterruptBadSequenceOfCorrectInstructions() {

        assertThrows(InvalidInstructionException.class, () -> robotController.followInstructions("MMMMMMMMMMMMMR"));

    }

}
