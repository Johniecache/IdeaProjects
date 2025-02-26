import bridges.base.Color;
import bridges.base.ColorGrid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VerticalLineTest {

    private static final Color B = new Color("black");
    private static final Color W = new Color("white");
    private static final Color U = new Color("blue");

    @Test
    public void testShortLine() {
        ColorGrid cg = new ColorGrid(3, 3);
        VerticalLine p = new VerticalLine(1, 1, 2, U);
        p.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B},
                {B, B, U},
                {B, B, B}}, cg);
    }

    @Test
    public void testLongLine() {
        ColorGrid cg = new ColorGrid(3, 3);
        VerticalLine p = new VerticalLine(0, 1, 2, U);
        p.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, U},
                {B, B, U},
                {B, B, B}}, cg);
    }

    @Test
    public void testMultipleLines() {
        ColorGrid cg = new ColorGrid(4, 4);
        VerticalLine p = new VerticalLine(1, 3, 2, U);
        p.draw(cg);
        VerticalLine q = new VerticalLine(2, 3, 0, W);
        q.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B, B},
                {B, B, U, B},
                {W, B, U, B},
                {W, B, U, B}}, cg);
    }
    @Test
    public void testOverlappingLines() {
        ColorGrid cg = new ColorGrid(4, 4);
        VerticalLine vl1 = new VerticalLine(0, 2, 2, U);
        vl1.draw(cg);
        VerticalLine vl2 = new VerticalLine(1, 3, 2, W);
        vl2.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, U, B},
                {B, B, W, B},
                {B, B, W, B},
                {B, B, W, B}}, cg);
    }

    @Test
    public void testMultipleLinesAlternative() {
        ColorGrid cg = new ColorGrid(4, 4);
        VerticalLine p = new VerticalLine(0, 2, 1, W);
        p.draw(cg);
        VerticalLine q = new VerticalLine(1, 3, 3, U);
        q.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, W, B, B},
                {B, W, B, U},
                {B, W, B, U},
                {B, B, B, U}}, cg);
    }
}