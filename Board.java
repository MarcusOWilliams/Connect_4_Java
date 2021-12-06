import java.util.ArrayList;

//A class representing all methods relating to the board for the game
//I chose this as a class as it encompasses a few good related methods that were previously in the main function
//I allowed the class to create board objects of a variable width and height
//The methods included are, printing the board with variable counters, placing counters in the board, checking if any player has won and checking if the board is full
public class Board {

    //a 2d character array is initialized for the board
    private char[][] board;

    //an array of integers is initialized for columns containing empty spaces
    ArrayList emptySpaceColumns = new ArrayList<Integer>();


    public Board(int height, int width){

        //if either height or width is less than 1 an error is thrown
        if (height<1 || width<1) {
            throw new RuntimeException("Height and width of the board must be positive integers");
        }
        //the board is created as a 2d char array with desired height and width, currently empty
        board = new char[height][width];

        //each column is added to empty columns array
        for(int i = 1; i < width+1; i++){
            emptySpaceColumns.add(i);
        }
    }


    //print the current board to the console, including the given counters of both players
    //I refactored this code to allow variation in the counters given by the player
    //this method can also now print boards of varying sizes
    public void printBoard(char counterA, char counterB){

        for(int i=0; i<board.length-1; i++){
            for(int j=0; j<board[i].length; j++){
                //print either a piece or empty depending on if there is a counter or not at each position
                if(board[i][j] == counterA){
                    System.out.print(String.format("| %c ", counterA));
                }
                else if(board[i][j] == counterB){
                    System.out.print(String.format("| %c ", counterB));
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }

        //print the numbers at the bottom of the board, depending on the width given
        System.out.print("  1");
        for(int i=2; i<=board[0].length; i++){
            System.out.print("   "+i);
        }
        System.out.print("\n");
    }


    //take the input from a player and place the counter matching them in the correct column
    //This code has been refactored to make it much more concise and clear
    //The method now takes a player object and uses the getPiece and getOpponentPiece to check if a piece can be placed then the loop breaks once a piece has been placed rather than having a boolean object
    public void placeCounter(Player player, int position){

        for(int i=board.length-2; i>=0; i--){

            //check if each position in the given column contains a counter, if it doesn't place the counter at the lowest point on the board
            if(board[i][position-1] != player.getPiece() && board[i][position-1] != player.getOpponentsPiece()){
                board[i][position-1] = player.getPiece();


                //if the counter was placed at the top of the column, the column no longer has empty spaces.
                if(i == 0){
                    emptySpaceColumns.remove(Integer.valueOf(position));
                }

                //once it is placed, break the loop to stop entire column being filled
                break;

            }
        }
    }


    //this method checks for wins in all directions including diagonal
    //I refactored this code to make it so it does not have to be written out twice, once for each player piece
    public boolean checkForWin(char player){

        //count, used for checking the number of consecutive matching counters set to 0
        int count = 0;

        // check for wins along rows
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){

                //checks if the current position matches the player's character
                //while the consecutive columns continue to match, the count increases
                if(board[i][j] == player){
                    count = count + 1;

                    //if the count reaches 4 the player has won
                    if(count >= 4){
                        return true;
                    }
                }
                //if one of the spaces does not match the count is reset to 0
                else{
                    count = 0;
                }
            }

        }
        // checks for wins down columns
        count = 0;
        for(int i=0; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){

                //checks if the current position matches the player's character
                //while the consecutive columns continue to match, the count increases
                if(board[j][i] == player){
                    count = count + 1;

                    //if the count reaches 4 the player has won
                    if(count >= 4){
                        return true;
                    }
                }
                //if one of the spaces does not match the count is reset to 0
                else{
                    count = 0;
                }
            }
        }
        //check diagonal wins, both forward and backwards
        for(int i=0; i<2; i++) {

            for (int j = 0; j < board.length; j++) {
                char state = board[i][j];
                if (state == player) {
                    //forwards diagonal, checks going one down and one right each time, to find any line of 4
                    if (j < 4) {
                        if (board[i + 1][j + 1] == state && board[i + 2][j + 2] == state && board[i + 3][j + 3] == state) {
                            //if there is a match the game has been won
                            return true;
                        }
                    }
                    //backwards diagonal, checks going one down and one left each time, to find any line of 4
                    if (j > 2) {
                        if (board[i + 1][j - 1] == state && board[i + 2][j - 2] == state && board[i + 3][j - 3] == state) {
                            //if there is a match the game has been won
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    //returns true if there are no columns left with empty spaces
    public boolean isBoardFull(){
        if(emptySpaceColumns.isEmpty()){
            return true;
        }
        return false;
    }
}