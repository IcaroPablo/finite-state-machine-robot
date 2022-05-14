package com.nasa.explorer.robot.orientations;


import com.nasa.explorer.robot.Position;

public interface RobotOrientation {

    String showSymbol();

    Position move(Position currentPosition);

    RobotOrientation turnLeft();

    RobotOrientation turnRight();

    RobotOrientation pointNorth();

    RobotOrientation pointWest();

}
