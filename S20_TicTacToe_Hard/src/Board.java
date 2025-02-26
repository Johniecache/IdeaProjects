import java.util.Arrays;
import java.util.Scanner;

/**
 * Board class that creates a new board object to display to the screen and manipulate with different players input
 * @see java.util.Arrays
 * @author Caleb Thomas
 */
public class Board {
    private String[][] board; // 2d array of board
    private int rows; // # of rows
    private int cols; // # of cols

    /**
     * board constructor no input that sets the instance board
     */
    public Board(){
        board = new String[3][3]; // 3x3 board
        rows = 3;
        cols = 3;
        for(int i=0;i<rows;i++){ // loop through board 2d array and set each value as an "empty cell"
            for(int j=0;j<cols;j++){
                board[i][j] = "-"; // set each cell on instance board to "empty"
            }
        }
    }

    /**
     * set the position on the board
     * @param row the row
     * @param col the column
     * @param player the player (X or O)
     * @return whether it's available or not
     */
    public boolean setType(int row, int col, String player) {
        try{
            if (board[row][col].equals("-")) { // the board @ row and column is empty
                board[row][col] = player; // set the player to the input position
                return true; // return that it was successful
            }
            return false; // otherwise return it was unsuccessful
        } catch (Exception e){
            System.out.print("\nArray out of bounds: " + e);
            return false;
        }

    }

    /**
     * print the board to the screen
     */
    public String toString() {
        String[][] s = new String[3][3];

        System.out.print("\n");
        for (int i=0;i<rows;i++) { // loop through rows
            System.out.print("| "); // print sidebars after each row
            for (int j=0;j<cols;j++) { // loop through columns
                System.out.print(board[i][j] + " "); // print a whitespace between empty cells and sidebars
                s[i][j] = board[i][j];
            }
            System.out.println("|"); // after rows print another sidebar
        }
        System.out.print("\n");


        return Arrays.deepToString(s);
    }

    /**
     * checks to see if board is full or not
     * @return boolean of if board is full
     */
    public boolean fullBoard() {
        for (int i=0;i<rows;i++) { // loop through 2d array
            for (int j=0;j<cols;j++) {
                if (board[i][j].equals("-")) { // if any spot has an "empty" cell
                    return false; // return it is not full
                }
            }
        }
        return true; // otherwise it is full
    }


    /**
     * checks to see if there is a winner
     * @param player the player
     * @return boolean
     */
    public boolean winner(String player) {
        for (int i=0;i<rows;i++) {
            // check each row for input winner
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                System.out.print(player + "'s win"); // tell user who won
                return true; // if so return true
            }
        }
        for (int i=0;i<cols;i++) {
            // check each column for input winner
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                System.out.print(player + "'s win"); // tell user who won
                return true; // if so return true
            }
        }
        // check left to right diagonal for input winner
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            System.out.print(player + "'s win"); // tell user who won
            return true;
        }
        // check right to left diagonal for input winner
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            System.out.print(player + "'s win"); // tell user who won
            return true;
        }
        return false;
    }
}
