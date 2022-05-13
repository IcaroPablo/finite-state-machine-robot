package com.nasa.explorer.robot.orientations;

import com.nasa.explorer.robot.Position;

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
    public Position move(Position currentPosition) throws Exception {
        currentPosition.setY(currentPosition.getY() + 1);
        if(currentPosition.getY() >= 5) throw new Exception();
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