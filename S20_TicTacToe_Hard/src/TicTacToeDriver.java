import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeDriver {
    public static void main(String[] args) {
        Board b = new Board(); // set the board up
        Player p1 = new HumanPlayer("X"); // set new player to human player
        Player p2 = new ComputerPlayer("O"); // set next player to computer (computer vs human default settings)

        Scanner sc = new Scanner(System.in); // create new scanner object for input

        System.out.print("\nEnter # of players (0,1,2): "); // get input of players from the user
        int players = sc.nextInt();// # of players determines gameplay

        try { // getting user input in a try catch statement
            while(players<0||players>2) { // if players isn't 0,1, or 2, then try again
                System.out.print("\nNot 0, 1, or 2, try again: "); // re-prompt user for input
                players = sc.nextInt(); // try next line again
            }
        } catch (Exception e){
            throw new InputMismatchException("\nERROR (Not an integer): " + e); // if not an integer throw error
        }

        b.toString(); // print board to the screen for the first time (should all be "empty" cells)

        if(players==0){ // Check if any players are playing
            p1 = new ComputerPlayer("X"); // if not then set initialized human player to computer player
        }

        if(players==2){ // check if two players
            p2 = new HumanPlayer("O"); // if so set the initialized computer player to human player
        }

        // main game loop
        while(!b.fullBoard()){ // while the board is not full
            p1.setType(b); // have X play on board
            b.toString(); // print board to screen
            if(b.winner("X")){ // check to see if X has won
                break; // if true break the loop
            }
            if(b.fullBoard()){ // if the board is full
                b.toString(); // print the board before the loop breaks
                break;
            }
            p2.setType(b); // have O play on board
            b.toString(); // print board to screen
            if(b.winner("O")){ // check if O has won
                break; // if so break out of loop
            }
            if(b.fullBoard()){ // if the board is full
                b.toString(); // print the board before the loop breaks
                break;
            }
        }

    }
}
