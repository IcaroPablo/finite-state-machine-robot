package com.nasa.explorer.robot.orientations;


import com.nasa.explorer.robot.Position;

public interface RobotOrientation {

    String showSymbol();

    Position move(Position currentPosition) throws Exception;

    RobotOrientation turnLeft();

    RobotOrientation turnRight();

    RobotOrientation pointNorth();

    RobotOrientation pointWest();

}
