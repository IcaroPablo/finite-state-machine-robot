package com.nasa.explorer.orientationStates;


import com.nasa.explorer.config.RobotPosition;

public interface RobotOrientation {

    String showSymbol();

    RobotPosition move(RobotPosition currentPosition);

    RobotOrientation turnLeft();

    RobotOrientation turnRight();

    RobotOrientation pointNorth();

    RobotOrientation pointWest();

}
