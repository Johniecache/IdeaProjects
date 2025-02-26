import java.util.Random;

/**
 * creates a computer player object that will randomly manipulate the instance board
 * @see java.util.Arrays
 * @author Caleb Thomas
 */
public class ComputerPlayer extends Player{
    Random r; // initialized random object
    int row;
    int col;

    /**
     * default constructor for the computer player
     * @param type the marker type
     */
    public ComputerPlayer(String type){
        super(type); // setting marker type
        r = new Random(); // setting a new random for instance
    }

    /**
     * setting the position on the input board
     * @param b the board
     */
    public void setType(Board b){
        do {
            row = r.nextInt(3); // get a random int for the row
            col = r.nextInt(3); // get a random int for the column
        } while(!b.setType(row, col, this.getType())); // while the position
    }
}
