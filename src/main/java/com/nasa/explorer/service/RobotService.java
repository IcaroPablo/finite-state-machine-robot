package com.nasa.explorer.service;

import com.nasa.explorer.robot.RobotFSM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    @Autowired
    RobotFSM robotFSM;

    public String follow(String instructions) throws Exception {

        return robotFSM.follow(instructions);

    }

}
