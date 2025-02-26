//package com.gradescope.hw2;

import bridges.base.Color;
import bridges.base.ColorGrid;

public class Point extends Mark {
    private int x;
    private int y;

    public Point(int x, int y, Color c) {
        color = c;
        this.x = y;
        this.y = x;
    }

    @Override
    public void draw(ColorGrid cg) {
        cg.set(x,y,color);
    }
}
