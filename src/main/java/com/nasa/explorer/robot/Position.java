package com.nasa.explorer.robot;

public class Position {

    private final Integer[] range = {0, 1, 2, 3, 4};
    private Integer x = range[0];
    private Integer y = range[0];

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) { this.x = range[x]; }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = range[y];
    }

}
