//package com.gradescope.hw2;

import bridges.base.Color;
import bridges.base.ColorGrid;

public class DiagonalLine extends Mark {
    // The line is characterized by its start and end points. 
	// xs and ys store the start point coordinates
    private final int xs;
    private final int ys;
    // xe and ye store the end point coordinates
    private final int xe;
    private final int ye;

    public DiagonalLine(int x0, int y0, int x1, int y1, Color color) {
        /*
        // set the line color to c.
        // if x0 is smaller than x1, 
        //    use x0 as the start x-coordinate
        //    and x1 as the end x-coordinate
        // otherwise, do the opposite.
        // Do the analogous thing for the y-coordinates
         */

        // setting up all initial values with previously established conditions
        if(x0 < x1){
            this.xs = x0;
            this.ys = y0;
            this.xe = x1;
            this.ye = y1;
        }
        else{
            this.xs = x1;
            this.ys = y1;
            this.xe = x0;
            this.ye = y0;
        }
        this.color = color;
    }

    @Override
    public void draw(ColorGrid cg) {
        /*
        // Implement like procedure plotLine at
        // https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm
        // using (xs,ys) and (xe,ye) instead of (x0,y0) and (x1,y1).
        // Additionally, make sure to draw the current point 
        // at each iteration of the for loop.
         */

        int dx = Math.abs(xe - xs); // change in x
        int dy = Math.abs(ye - ys); // change in y

        int sx; // find direction of x's movement
        if(xs < xe){
            sx = 1; // if less than xs then move right
        }
        else {
            sx = -1; // otherwise move it left
        }

        int sy; // find direction of y's movement
        if(ys < ye){
            sy = 1; // if less than xs then move it down
        }
        else {
            sy = -1; // otherwise move it up
        }

        int err = dx - dy; // error term of Bresenham's algorithm

        int x = xs; // initial x position
        int y = ys; // initial y position

        while(true){

            cg.set(x,y,color); // draw point at current position

            if(x == xe && y == ye){ // check if at end of grid
                break; // if so break out of loop
            }

            int e2 = 2 * err; // double the error term for Bresenham's algorithm

            if(e2 > -dy){
                err -= dy; // adjust the error
                x += sx; // move the x position
            }
            if(e2 < dx){
                err += dx; // adjust the error
                y += sy; // move the y position
            }
        }
    }
}


