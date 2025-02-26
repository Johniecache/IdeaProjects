//package com.gradescope.hw2;

import bridges.base.Color;
import bridges.base.ColorGrid;

public class HorizontalLine extends Mark {
    private int start;
    private int end;
    private int y;
    private Color color;

    public HorizontalLine(int start, int end, int y, Color c) {
        this.start = start;
        this.end = end;
        this.y = y;
        this.color = c;
    }

    @Override
    public void draw(ColorGrid cg) {
        for(int x=start;x<=end;x++){ // loop through each element from the input start to end
            cg.set(y,x,color); // set each element as that color
        }
    }
}
