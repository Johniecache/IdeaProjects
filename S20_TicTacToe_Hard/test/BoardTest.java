import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    @Test
    void setType() {
        Board b1 = new Board();
        Board b2 = new Board();
        Board b3 = new Board();
        b1.setType(0 , 0, "O");
        b2.setType(0,0,"X");
        b3.setType(1,1,"X");
        b3.setType(0,0,"O");


        assertEquals(b1.toString(),"[[O, -, -], [-, -, -], [-, -, -]]");
        assertEquals(b2.toString(),"[[X, -, -], [-, -, -], [-, -, -]]");
        assertEquals(b3.toString(), "[[O, -, -], [-, X, -], [-, -, -]]");
    }

    @Test
    void testToString() {
        Board b1 = new Board();

        assertEquals(b1.toString(), "[[-, -, -], [-, -, -], [-, -, -]]");
    }

    @Test
    void fullBoard() {
        Board b1 = new Board();
        Board b2 = new Board();
        b1.setType(0,0,"X");
        b1.setType(0,1,"O");
        b1.setType(0,2,"X");

        b1.setType(1,0,"O");
        b1.setType(1,1,"X");
        b1.setType(1,2,"O");

        b1.setType(2,0,"O");
        b1.setType(2,1,"X");
        b1.setType(2,2,"X");

        assertEquals(b1.fullBoard(), true);
        assertEquals(b2.fullBoard(), false);

    }

    @Test
    void winner() {
        Board b1 = new Board();
        Board b2 = new Board();
        Board b3 = new Board();

        b1.setType(0,0,"X");
        b1.setType(0,1,"X");
        b1.setType(0,2,"X");

        b2.setType(0,0,"O");
        b2.setType(1,0,"O");
        b2.setType(2,0,"O");

        assertEquals(b1.winner("X"), true);
        assertEquals(b1.winner("O"), false);
        assertEquals(b2.winner("O"), true);
        assertEquals(b2.winner("X"), false);
        assertEquals(b3.winner("X"), false);
        assertEquals(b3.winner("O"), false);

    }
}