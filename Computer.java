import java.util.ArrayList;

//The Human class extends from the Player superclass, this is the class used to handle the methods for the person playing the game
//it inherits all of the attributes from the Player class
//the takeInput method is overwritten from the superclass, it allows a random input to be taken for the computers move
//I allowed the computer to have variable characters for their piece which was not possible in the original game
public class Computer extends Player{

    public Computer(char piece,char opponentsPiece, String name){
        //gives the computer object the inherited variables from the player class
        super(piece, opponentsPiece, name);
    }

    //selects a random integer from the list of columns with empty spaces
    //Lets the human player know what column was selected and returns the column number
    @Override
    public int takeInput(ArrayList<Integer> emptySpaceColumns) {

        int randomIndex = (int)(Math.random() * emptySpaceColumns.size());


        int computerSelection = emptySpaceColumns.get(randomIndex);

        System.out.println(String.format("The computer placed a counter in column %d", computerSelection));

        return computerSelection;
    }
}
