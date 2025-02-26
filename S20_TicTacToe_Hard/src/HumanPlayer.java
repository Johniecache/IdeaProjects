import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Creates a human player object that will take user input and manipulate the board instance object
 * @see java.util.Arrays
 * @author Caleb Thomas
 */
public class HumanPlayer extends Player{
    Scanner sc = new Scanner(System.in);
    int row;
    int col;

    /**
     * default constructor with input
     * @param type the marker type
     */
    public HumanPlayer(String type){
        super(type); // setting marker type
    }

    /**
     * setter of the position
     * @param b the board as input
     */
    public void setType(Board b){
        do {
            System.out.print("\nEnter row and column for position wanted (row column): ");
            row = sc.nextInt();
            col = sc.nextInt();
        } while(!b.setType(row,col,this.getType()));
    }
}
