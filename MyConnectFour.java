import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MyConnectFour {

	public static void main(String[] args){
		new MyConnectFour();
	}
	
	private BufferedReader input;


	Board board = new Board(6,7);
	Human human = new Human('r','y');
	Computer computer = new Computer('y','r');

	public MyConnectFour(){
		playGame();
	}

	// overall method for playing the game, prints out the rules then gets input and returns an updated board until somebody has won
	private void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		board.printBoard();
		boolean win = false;
		while(!win){
			// player 1



			int move = human.getUserInput(board.emptyColumns());
			board.placeCounter(human.getPlayerPiece(), human.getOppPiece(), move);
			win = board.hasWon(human.getPlayerPiece());
			if(win){
				break;
			}

			//player 2
			int compInput = computer.getComputerInput(board.emptyColumns());
			board.placeCounter(computer.getPlayerPiece(), computer.getOppPiece(), compInput);
			win = board.hasWon(computer.getPlayerPiece());

		}

	}


}
