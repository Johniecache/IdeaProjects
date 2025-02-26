import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    void getType() {
        Player p1 = new ComputerPlayer("X");
        Player p2 = new ComputerPlayer("O");

        assertEquals(p1.getType(), "X");
        assertEquals(p2.getType(), "O");
    }
}