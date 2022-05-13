package com.nasa.explorer.robot.orientations;

import com.nasa.explorer.robot.Position;

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
    public Position move(Position currentPosition) throws Exception {
        currentPosition.setX(currentPosition.getX() - 1);
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
    public RobotOrientation pointWest() { return this; }
}