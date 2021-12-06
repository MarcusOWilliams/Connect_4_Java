import java.util.*;


public class Board {


    private char[][] board;


    private int[] columns = new int[7];

    public Board(int height, int width) {
        board = new char[height][width];
        System.out.println(board.length);
    }


    public boolean hasWon(char player){

        boolean hasWon = false;
        boolean draw = false;
        // check horizontal
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {
                    count = count + 1;
                    if (count >= 4) {
                        hasWon = true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // check vertical
        count = 0;
        for(int j=0; j<board[0].length; j++){
            for(int i=0; i<board.length; i++){
                if(board[i][j] == player){
                    count = count + 1;
                    if(count >= 4){
                        hasWon = true;
                    }
                } else{
                    count = 0;
                }
            }
            count = 0;
        }
        //check positive diagonal
        for(int i=0; i<board.length-3; i++){
            for(int j=0; j<board[0].length-3; j++){
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    hasWon = true;
                    break;
                }
            }
        }
        //check negative diagonal
        for(int i=0; i<board.length-3; i++){
            for(int j=3; j<board[0].length-3; j++){
                if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
                    hasWon = true;
                    break;
                }
            }
        }
        // check draw
        for(int i =0; i < columns.length; i++){
            if(columns[i] != 6){
                break;
            } else if(i == columns.length-1){
                draw = true;
            }
        }



        printBoard();
        if(hasWon){
            if(player == 'r'){
                System.out.println("Player 1 Won!!!");}
            else{
                System.out.println("Player 2 Won!!!");
            }
            return true;
            //check for draw
        }else if(draw){
            System.out.println("Draw");
            return true;
        }

        return false;
    }
            // player 1





    // print out the board
    public void printBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'r'){
                    System.out.print("| r ");
                }
                else if(board[i][j] == 'y'){
                    System.out.print("| y ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    //place the counter by checking if the potential square is full, if it is empty place it
    public void placeCounter(char player, char opponent, int position){
        boolean placed = false;
        for(int i= board.length-1; i>=0; i--){
            if(!placed){
                if(board[i][position-1] == opponent){
                    //
                }
                else if(board[i][position-1] != player){
                    board[i][position-1] = player;
                    placed = true;
                }
            }
        }
        if(!placed){
            System.out.println("Column Full");
        }
    }

    // check each square in the board an determine if it is empty, if it is add 1 to that column number,
    // after, if a column is not full add that column to the empty list
    public List<Integer> emptyColumns() {
        List<Integer> empty = new ArrayList<>();
        int[] columns = new int[7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'r' || board[i][j] == 'y') {
                    columns[j] = columns[j] + 1;
                }
            }
        }
       for(int i = 0; i < columns.length; i++){
           if(columns[i]<6){
               empty.add(i+1);
           }
       }

       return empty;
    }

}
