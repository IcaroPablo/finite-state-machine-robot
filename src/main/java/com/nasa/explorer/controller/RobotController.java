package com.nasa.explorer.controller;

import com.nasa.explorer.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/rest")
@Validated
public class RobotController {

    @Autowired
    RobotService robotService;

    @PostMapping("/mars/{instructions}")
    public ResponseEntity<?> followInstructions(
            @PathVariable("instructions")
            @Pattern(regexp = "[LRM]{1,}")
                    String instructions) {

        try {
            String endPosition = robotService.follow(instructions);
            return ResponseEntity.status(HttpStatus.OK).body(endPosition);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request");
        }

    }

}
