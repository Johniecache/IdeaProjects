
import bridges.base.Color;
import bridges.base.ColorGrid;

import org.junit.Test;

public class CircleTest {
    private static final Color B = new Color("black");
    private static final Color W = new Color("white");
    private static final Color U = new Color("blue");

    @Test
    public void testPointCircleTest() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle = new Circle(0, 4, 4, W);
        circle.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B}}, cg);
    }

    @Test
    public void testOneRadiusCircleTest() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle = new Circle(1, 4, 4, W);
        circle.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, W, B, W, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B}}, cg);
    }

    @Test
    public void testTwoRadiusCircleTest() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle = new Circle(2, 4, 4, W);
        circle.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, W, B, W, B, B, B},
                {B, B, W, B, B, B, W, B, B},
                {B, B, B, W, B, W, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, B, B, B, B, B}}, cg);
    }

    @Test
    public void testThreeRadiusCircleTest() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle = new Circle(3, 4, 4, W);
        circle.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, W, B, W, B, B, B},
                {B, B, W, B, B, B, W, B, B},
                {B, W, B, B, B, B, B, W, B},
                {B, B, W, B, B, B, W, B, B},
                {B, B, B, W, B, W, B, B, B},
                {B, B, B, B, W, B, B, B, B},
                {B, B, B, B, B, B, B, B, B}}, cg);
    }

    @Test
    public void testFourRadiusCircleTest() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle = new Circle(4, 4, 4, W);
        circle.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, W, W, W, B, B, B},
                {B, B, W, B, B, B, W, B, B},
                {B, W, B, B, B, B, B, W, B},
                {W, B, B, B, B, B, B, B, W},
                {W, B, B, B, B, B, B, B, W},
                {W, B, B, B, B, B, B, B, W},
                {B, W, B, B, B, B, B, W, B},
                {B, B, W, B, B, B, W, B, B},
                {B, B, B, W, W, W, B, B, B}}, cg);
    }

    @Test
    public void testMultipleCirclesTest() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle1 = new Circle(1, 2, 2, W);
        circle1.draw(cg);
        Circle circle2 = new Circle(2, 6, 6, U);
        circle2.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, B, B, B, B, B, B},
                {B, B, W, B, B, B, B, B, B},
                {B, W, B, W, B, B, B, B, B},
                {B, B, W, B, B, B, B, B, B},
                {B, B, B, B, B, B, U, B, B},
                {B, B, B, B, B, U, B, U, B},
                {B, B, B, B, U, B, B, B, U},
                {B, B, B, B, B, U, B, U, B},
                {B, B, B, B, B, B, U, B, B}}, cg);
    }

    @Test
    public void testOverlappingCircles() {
        ColorGrid cg = new ColorGrid(9, 9);
        Circle circle1 = new Circle(2, 3, 3, W);
        circle1.draw(cg);
        Circle circle2 = new Circle(2, 5, 5, U);
        circle2.draw(cg);
        TestUtilities.checkCG(new Color[][]{
                {B, B, B, B, B, B, B, B, B},
                {B, B, B, W, B, B, B, B, B},
                {B, B, W, B, W, B, B, B, B},
                {B, W, B, B, B, U, B, B, B},
                {B, B, W, B, U, B, U, B, B},
                {B, B, B, U, B, B, B, U, B},
                {B, B, B, B, U, B, U, B, B},
                {B, B, B, B, B, U, B, B, B},
                {B, B, B, B, B, B, B, B, B}}, cg);
    }
}