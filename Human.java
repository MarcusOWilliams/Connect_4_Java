import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


//The Human class extends from the Player superclass, this is the class used to handle the methods for the person playing the game
//it inherits all of the attributes from the Player class and adds another one for taking the humans input
//the takeInput method is overwritten from the superclass, this allows the player to select a column to place their piece
//I allowed the player to have variable characters for their piece which was not possible in the original game
public class Human extends Player{

    private BufferedReader humanInput;

    public Human(char piece,char opponentsPiece, String name){
        //gives the Human object the inherited variables from the player class
        super(piece, opponentsPiece, name);

        //initiates an input for the human to give their columns
        humanInput = new BufferedReader(new InputStreamReader(System.in));
    }

    //takes an input from the human and checks it is a valid integer
    //I changed this code to make sure the input is a valid integer and is a column number that has room to place a piece
    //this method also now converts the string to an integer before returning it
    @Override
    public int takeInput(ArrayList<Integer> emptySpaceColumns) {

        //the input string and integer to return are declared
        String inputValue;
        int toReturn = 0;

        //Inputs continue to be taken until the human gives an input that is an integer within the empty space columns
        while (!(emptySpaceColumns.contains(toReturn))){

            //the user is asked to give an input ans is shown the available column numbers
            System.out.print("Please enter a non-full column 1-7, available columns: ");
            for(Object i: emptySpaceColumns){
                System.out.print(i+" ");
            }
            System.out.print("\n");

            //the system take the input and tries to convert it to an integer
            //if the input can't be converted, the exception is caught and the user is asked to try again
            try {
                inputValue = humanInput.readLine();
                toReturn = Integer.parseInt(inputValue);

            } catch (Exception IllegalArgumentException) {
                System.out.println("Your input was not an integer");
            }
        }
        //once the input is valid the integer value is returned
        return toReturn;
    }
}
