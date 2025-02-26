import bridges.base.Color;
import bridges.base.ColorGrid;
import org.junit.Test;

public class HorizontalLineTest {

    private static final Color B = new Color("black");
    private static final Color W = new Color("white");
    private static final Color U = new Color("blue");

    @Test
    public void testShortLine() {
        ColorGrid cg = new ColorGrid(3, 3);
        HorizontalLine p = new HorizontalLine(1, 1, 2, U);
        p.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B},
                {B, B, B},
                {B, U, B}}, cg);
    }

    @Test
    public void testLongLine() {
        ColorGrid cg = new ColorGrid(3, 3);
        HorizontalLine p = new HorizontalLine(0, 1, 2, U);
        p.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B},
                {B, B, B},
                {U, U, B}}, cg);
    }

    @Test
    public void testMultipleLines() {
        ColorGrid cg = new ColorGrid(4, 4);
        HorizontalLine p = new HorizontalLine(1, 3, 2, U);
        p.draw(cg);
        HorizontalLine q = new HorizontalLine(2, 3, 0, W);
        q.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, W, W},
                {B, B, B, B},
                {B, U, U, U},
                {B, B, B, B}}, cg);
    }
@Test
    public void testOverlappingHorizontalLines() {
        ColorGrid cg = new ColorGrid(4, 4);
        HorizontalLine hl1 = new HorizontalLine(0, 2, 2, W);
        hl1.draw(cg);
        HorizontalLine hl2 = new HorizontalLine(2, 3, 2, U);
        hl2.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B, B},
                {B, B, B, B},
                {W, W, U, U},
                {B, B, B, B}}, cg);
    }

    @Test
    public void testMultipleLinesAlternative() {
        ColorGrid cg = new ColorGrid(4, 4);
        HorizontalLine p = new HorizontalLine(0, 2, 3, W);
        p.draw(cg);
        HorizontalLine q = new HorizontalLine(2, 3, 1, U);
        q.draw(cg);
        TestUtilities.checkCG(new Color[][] {
                {B, B, B, B},
                {B, B, U, U},
                {B, B, B, B},
                {W, W, W, B}}, cg);
    }
}