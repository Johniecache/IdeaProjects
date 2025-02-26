//package com.gradescope.hw2;

import bridges.base.ColorGrid;
import bridges.base.Color;

public abstract class Mark {
    // this is protected (rather than private) so that
    // subclasses of Mark can access it
    protected Color color;

    public Mark(){
        this.color = new Color("black"); // sets default constructor of Mark to be black
    }

    public Mark(Color c){
        this.color = c; // sets input color to the instance color
    }

    /*
    Returns true if and only if the given Color
    is the same as this Mark's Color. Two Colors
    are considered the same if their Red, Green,
    Blue, and Alpha components are equal.
    c: the Color to check against
     */
    public boolean isColor(Color c) {
        if(c == null || this.color == null){ // if the color input and the instance color are both null
            return false;
        }
        if(c.getRed() == this.color.getRed()){ // if input color and instance color are red
            return true;
        }
        if(c.getGreen() == this.color.getGreen()){ // if input color and instance color are green
            return true;
        }
        if(c.getBlue() == this.color.getBlue()){ // if input color and instance color are blue
            return true;
        }
        if(c.getAlpha() == this.color.getAlpha()){ // if input color and instance color are alpha
            return true;
        }
        return false; // if no tests pass then return false
    }

    /*
    Draws this Mark onto the given ColorGrid
    cg: the ColorGrid to draw onto
     */
    public abstract void draw(ColorGrid cg);
}
