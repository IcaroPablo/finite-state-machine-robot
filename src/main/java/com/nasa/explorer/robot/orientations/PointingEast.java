package com.nasa.explorer.robot.orientations;

import com.nasa.explorer.robot.Position;

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
    public Position move(Position currentPosition) throws Exception {
        currentPosition.setX(currentPosition.getX() + 1);
        if(currentPosition.getY() >= 5) throw new Exception();
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
