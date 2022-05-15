package com.nasa.explorer.orientationStates.impl;

import com.nasa.explorer.config.RobotPosition;
import com.nasa.explorer.orientationStates.RobotOrientation;

public class PointingWest implements RobotOrientation {

    private final RobotOrientation left;
    private final RobotOrientation right;

    public PointingWest(RobotOrientation south) {

        this.left = south;
        this.right = pointNorth();

    }

    @Override
    public String showSymbol() { return "W"; }

    @Override
    public RobotPosition move(RobotPosition currentPosition) {
        currentPosition.setX(currentPosition.getX() - 1);
        return currentPosition;
    }

    @Override
    public RobotOrientation turnLeft() { return left; }

    @Override
    public RobotOrientation turnRight() { return right; }

    @Override
    public RobotOrientation pointNorth() { return left.pointNorth(); }

    @Override
    public RobotOrientation pointWest() { return this; }
}