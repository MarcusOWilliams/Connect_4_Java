import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Human extends Player{
    private final BufferedReader userInput;


    // instantiate the human player and the BufferedReader for getting input
    public Human(char playerPiece, char oppPiece) {
        super(playerPiece, oppPiece);
        userInput = new BufferedReader(new InputStreamReader(System.in));
    }


    // get the users input until a valid input is given ( between 1-7 and an empty column) and then return that
    public int getUserInput(List<Integer> possible){

        String toReturn;
        int intInput = 0;
        while((intInput<=0 || intInput > 7) || !possible.contains(intInput)){
            System.out.println("Please enter a non-full column 1-7");
            try {
                toReturn = userInput.readLine();
                intInput = Integer.parseInt(toReturn);


            } catch (Exception e) {
            }
        }
        return intInput;
    }

}
