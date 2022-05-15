package com.nasa.explorer.orientationStates.impl;

import com.nasa.explorer.config.RobotPosition;
import com.nasa.explorer.orientationStates.RobotOrientation;

public class PointingNorth implements RobotOrientation {

    private final RobotOrientation left;
    private final RobotOrientation right;

    public PointingNorth() {

        this.right = new PointingEast(this);
        this.left = pointWest();

    }

    @Override
    public String showSymbol() { return "N"; }

    @Override
    public RobotPosition move(RobotPosition currentPosition) {
        currentPosition.setY(currentPosition.getY() + 1);
        return currentPosition;
    }

    @Override
    public RobotOrientation turnLeft() {
        return left;
    }

    @Override
    public RobotOrientation turnRight() {
        return right;
    }

    @Override
    public RobotOrientation pointNorth() {
        return this;
    }

    @Override
    public RobotOrientation pointWest() { return right.pointWest(); }
}
