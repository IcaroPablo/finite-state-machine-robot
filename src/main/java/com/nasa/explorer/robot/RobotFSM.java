package com.nasa.explorer.robot;

import com.nasa.explorer.robot.orientations.PointingNorth;
import com.nasa.explorer.robot.orientations.RobotOrientation;
import org.springframework.stereotype.Service;

@Service
public class RobotFSM {

    private Position currentPosition;
    private RobotOrientation currentOrientation;

    public RobotFSM() {

        this.currentPosition = new Position(0, 0);
        this.currentOrientation = new PointingNorth();

    }

    public String follow(String instructions) throws Exception {

        for (int i = 0; i < instructions.length(); i++) {

            if(instructions.charAt(i) == (("M").charAt(0))) currentPosition = currentOrientation.move(currentPosition);
            else if(instructions.charAt(i) == (("L").charAt(0))) currentOrientation = currentOrientation.turnLeft();
            else if(instructions.charAt(i) == (("R").charAt(0))) currentOrientation = currentOrientation.turnRight();
        }

        String endPosition = this.toString();
        reset();

        return endPosition;

    }

    public void reset() {

        this.currentPosition.setX(0);
        this.currentPosition.setY(0);
        this.currentOrientation = currentOrientation.pointNorth();

    }

    @Override
    public String toString() {
        return "(" + currentPosition.getX() +
                ", " + currentPosition.getY() +
                ", " + currentOrientation.showSymbol() + ")";
    }
}
