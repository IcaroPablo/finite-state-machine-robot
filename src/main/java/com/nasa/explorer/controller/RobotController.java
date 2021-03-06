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
    private RobotService robotService;

    @PostMapping("/mars/{instructions}")
    public ResponseEntity<?> followInstructions (
            @PathVariable("instructions")
            @Pattern(regexp = "[LRM]+")
                    String instructions) {

        return ResponseEntity.status(HttpStatus.OK).body(robotService.follow(instructions));

    }

}
