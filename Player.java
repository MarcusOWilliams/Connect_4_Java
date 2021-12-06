import java.util.ArrayList;

//Player is an abstract class used to act as a parent for the Human and Computer classes
//I created this class to decrease the amount of duplicated clone as both computer and Human will require some common attributes and methods.
//This class has 3 attributes for the pieces in the game and the name of the player along with a method to return each attribute
//There is also an abstract method for taking an input from a player, this method is overwritten in each child class to give the necessary functionality
//abstraction and inheritance are key OOP principles, this class helps to keep the code clear and reduce code duplication
abstract class Player {

    //declares variables for the players piece, their opponents piece and their name
    private char piece;
    private char opponentsPiece;
    private String name;


    public Player(char piece,char opponentsPiece, String name){
        this.piece = piece;
        this.opponentsPiece = opponentsPiece;
        this.name = name;
    }

    //methods for returning the player piece, their opponents piece and their name
    public String getName(){
        return this.name;
    }
    public char getPiece(){return this.piece;}
    public char getOpponentsPiece(){return this.opponentsPiece;}


    //an abstract class to take an input from the player, overwritten in the Human and Computer classes
    public abstract int takeInput(ArrayList<Integer> emptySpaceColumns);
}
