//package com.gradescope.hw2;

import bridges.base.Color;
import bridges.base.ColorGrid;

public class VerticalLine extends Mark {
    private int start;
    private int end;
    private int x;
    private Color color;

    public VerticalLine(int start, int end, int x, Color c) {
        this.x = x;
        this.start = start;
        this.end = end;
        this.color = c;
    }

    @Override
    public void draw(ColorGrid cg) {
        for(int y=start;y<=end;y++){ // loop through elements in the grid from input start to input end
            cg.set(y,x,color); // set all elements within the input positions to the input color
        }
    }
}
