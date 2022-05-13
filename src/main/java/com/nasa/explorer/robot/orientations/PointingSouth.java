package com.nasa.explorer.robot.orientations;

import com.nasa.explorer.robot.Position;

public class PointingSouth implements RobotOrientation {

    private final RobotOrientation left;
    private final RobotOrientation right;

    public PointingSouth(RobotOrientation east) {

        this.left = east;
        this.right = new PointingWest(this);

    }

    @Override
    public String showSymbol() { return "S"; }

    @Override
    public Position move(Position currentPosition) throws Exception {
        currentPosition.setY(currentPosition.getY() - 1);
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