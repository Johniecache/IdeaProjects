//package com.gradescope.hw2.tests;

import bridges.base.Color;
import bridges.base.ColorGrid;

//import com.gradescope.hw2.DiagonalLine;

//import com.gradescope.jh61b.grader.GradedTest;

import org.junit.Test;

public class DiagonalLineTest {
    private static final Color B = new Color("black");
    private static final Color W = new Color("white");
    private static final Color U = new Color("blue");

    @Test
    public void testSinglePointLine() {
        ColorGrid cg = new ColorGrid(4, 4);
        DiagonalLine dl = new DiagonalLine(1, 1, 1, 1, W);
        dl.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B, B},
                {B, W, B, B},
                {B, B, B, B},
                {B, B, B, B}}, cg);
    }

    @Test
    public void testTwoPointLine() {
        ColorGrid cg = new ColorGrid(4, 4);
        DiagonalLine dl = new DiagonalLine(1, 1, 2, 2, W);
        dl.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B, B},
                {B, W, B, B},
                {B, B, W, B},
                {B, B, B, B}}, cg);
    }

    @Test
    public void testThreePointLine() {
        ColorGrid cg = new ColorGrid(4, 4);
        DiagonalLine dl = new DiagonalLine(0, 0, 2, 2, W);
        dl.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {W, B, B, B},
                {B, W, B, B},
                {B, B, W, B},
                {B, B, B, B}}, cg);
    }

    @Test
    public void testFourPointLine() {
        ColorGrid cg = new ColorGrid(4, 4);
        DiagonalLine dl = new DiagonalLine(1, 0, 2, 3, W);
        dl.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, W, B, B},
                {B, W, B, B},
                {B, B, W, B},
                {B, B, W, B}}, cg);
    }

    @Test
    public void testMultipleDiagonalLines() {
        ColorGrid cg = new ColorGrid(4, 4);
        DiagonalLine dl1 = new DiagonalLine(0, 1, 3, 2, W);
        dl1.draw(cg);
        DiagonalLine dl2 = new DiagonalLine(0, 3, 3, 0, U);
        dl2.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B, U},
                {W, W, U, B},
                {B, U, W, W},
                {U, B, B, B}}, cg);
    }

    @Test
    public void testOverlappingDiagonalLines() {
        ColorGrid cg = new ColorGrid(4, 4);
        DiagonalLine dl1 = new DiagonalLine(0, 0, 3, 3, W);
        dl1.draw(cg);
        DiagonalLine dl2 = new DiagonalLine(1, 3, 3, 1, U);
        dl2.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {W, B, B, B},
                {B, W, B, U},
                {B, B, U, B},
                {B, U, B, W}}, cg);
    }
}
