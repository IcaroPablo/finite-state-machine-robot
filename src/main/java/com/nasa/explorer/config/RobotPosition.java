package com.nasa.explorer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RobotPosition {

    private final Integer[] rangeX;
    private final Integer[] rangeY;

    private Integer x;
    private Integer y;

    public RobotPosition(@Value("${robot.xFieldRange}") Integer maxXRange,
                         @Value("${robot.xFieldRange}") Integer maxYRange) {

        this.rangeX = new Integer[maxXRange];
        this.rangeY = new Integer[maxYRange];

        for (int i = 0; i < rangeX.length; i++) { rangeX[i] = i; }
        for (int i = 0; i < rangeY.length; i++) { rangeY[i] = i; }

        this.x = rangeX[0];
        this.y = rangeY[0];

    }

    public Integer getX() { return x; }

    public void setX(Integer x) { this.x = rangeX[x]; }

    public Integer getY() { return y; }

    public void setY(Integer y) { this.y = rangeY[y]; }

}
