import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    @Test
    void getType() {
        Player p1 = new HumanPlayer("X");
        Player p2 = new HumanPlayer("O");

        assertEquals(p1.getType(), "X");
        assertEquals(p2.getType(), "O");
    }
}