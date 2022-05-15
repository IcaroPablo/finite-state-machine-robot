package com.nasa.explorer.service;

import com.nasa.explorer.config.RobotPosition;
import com.nasa.explorer.exception.InvalidInstructionException;
import com.nasa.explorer.orientationStates.RobotOrientation;
import com.nasa.explorer.orientationStates.impl.PointingNorth;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    private RobotPosition currentPosition = new RobotPosition();
    private RobotOrientation currentOrientation = new PointingNorth();

    public String follow(String instructions) {

        try {
            execute(instructions);
            return getCurrentPosition();
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new InvalidInstructionException("Robot outside the expected field");
        } finally {
            goBackToStartPosition();
        }

    }

    private void execute(String instructions) {

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'M')
                currentPosition = currentOrientation.move(currentPosition);
            else if (instructions.charAt(i) == 'L')
                currentOrientation = currentOrientation.turnLeft();
            else if (instructions.charAt(i) == 'R')
                currentOrientation = currentOrientation.turnRight();
        }

    }

    private void goBackToStartPosition() {

        this.currentPosition.setX(0);
        this.currentPosition.setY(0);
        this.currentOrientation = currentOrientation.pointNorth();

    }

    private String getCurrentPosition() {

        return "(" + currentPosition.getX() +
                ", " + currentPosition.getY() +
                ", " + currentOrientation.showSymbol() + ")";

    }
}
