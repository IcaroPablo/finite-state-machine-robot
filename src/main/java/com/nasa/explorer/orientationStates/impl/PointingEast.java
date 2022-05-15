package com.nasa.explorer.orientationStates.impl;

import com.nasa.explorer.config.RobotPosition;
import com.nasa.explorer.orientationStates.RobotOrientation;

import javax.validation.ConstraintViolationException;

public class PointingEast implements RobotOrientation {

    private final RobotOrientation left;
    private final RobotOrientation right;

    public PointingEast(RobotOrientation north) {

        this.left = north;
        this.right = new PointingSouth(this);

    }

    @Override
    public String showSymbol() { return "E"; }

    @Override
    public RobotPosition move(RobotPosition currentPosition) throws ConstraintViolationException {
        currentPosition.setX(currentPosition.getX() + 1);
        return currentPosition;
    }

    @Override
    public RobotOrientation turnLeft() { return left; }

    @Override
    public RobotOrientation turnRight() { return right; }

    @Override
    public RobotOrientation pointNorth() { return left.pointNorth(); }

    @Override
    public RobotOrientation pointWest() { return right.pointWest(); }
}
