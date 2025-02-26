
/**
 * player class that is a parent class to the human and computer player such that they can set and get a marker type
 * @see java.util.Arrays
 * @author Caleb Thomas
 */
public abstract class Player { // abstract so that only human & computer player can set a marker type
    private String type;

    /**
     * default constructor of the player
     * @param type the marker type
     */
    public Player(String type){
        this.type = type; // type of marker the player will be using
    }

    /**
     * getting the marker type
     * @return the marker type
     */
    public String getType(){
        return this.type; // getting marker type of instance player
    }

    /**
     * abstract set marker type of the input board
     * @param b the board
     */
    public abstract void setType(Board b); // inherited from Player class
}
