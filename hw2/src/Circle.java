//package com.gradescope.hw2;

import bridges.base.Color;
import bridges.base.ColorGrid;

public class Circle extends Mark {
    private final int r;  // radius
    private final int xc; // center x-coordinate
    private final int yc; // center y-coordinate
    private final Color color;

    public Circle(int radius, int xc, int yc, Color color) {
        this.r = radius;
        this.xc = xc;
        this.yc = yc;
        this.color = color;
    }

    private void octantSymm(int x1, int y1, int x2, int y2, ColorGrid cg) {
        // draw on the given color grid the points
        // with the following coordinates

        cg.set(x1 - y2, y1 + x2, color);
        cg.set(x1 - y2, y1 + x2, color);
        cg.set(x1 - x2, y1 + y2, color);
        cg.set(x1 - x2, y1 - y2, color);
        cg.set(x1 - y2, y1 - x2, color);
        cg.set(x1 + y2, y1 - x2, color);
        cg.set(x1 + x2, y1 - y2, color);
        cg.set(x1 + x2, y1 + y2, color);
        cg.set(x1 + y2, y1 + x2, color);

    }
    @Override
    public void draw(ColorGrid cg) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;
        octantSymm(yc, xc, y, x, cg);
        while (y >= x) {
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + 10;
            } else d = d + 4 * x + 6;
            octantSymm(yc, xc, y, x, cg);
        }
    }
}
