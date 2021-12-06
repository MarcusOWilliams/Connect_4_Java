import java.util.*;


public class Computer extends Player{


    // instantiate the computer player
    public Computer(char playerPiece, char oppPiece) {
        super(playerPiece, oppPiece);

    }

    // the computer select a random number from the list of available columns
    public int getComputerInput(List<Integer> possible){
        Random choice = new Random();
        int index = choice.nextInt(possible.size());
        return possible.get(index);

    }


}
