//I still have the same main MyConnectFour class, but much of the code has been modularised and encapsulated into more specific classes
//I selected my classes based on the key components of the game, I considered these to be the board, the players and the main class.
//This allowed me to use many of teh key OOP principles, by splitting the code into class/modules I was able to break down problems, making them easier to solve
//I was able to encapsulate related methods, this helped to hide the values/states of data within classes, showing the main class only what was required, leading to clearer code
//I was also able to implement the use of abstract classes, inheritance and polymorphisms by creating a superclass for players which was inherited by both the Human and PLayer class.
public class MyConnectFour {
	
//	A board object is created of the desired height and width
	Board board = new Board(6,7);

	//A human object is created, this acts as the human player for the game, called player 1
	Human human = new Human('r', 'y', "Player 1");

	//A computer object is created allowing the player to play against the computer
	Computer computer = new Computer('y', 'r', "The Computer");



	
	public MyConnectFour(){
		//The playGame function is called, starting the game
		playGame();
	}

	//I kept the original play game function but refactored the majority of the code within it into other classes to make it cleaner
	//I made the code more efficient for some of the methods by removing the need for writing everything twice (once for each player)
	private void playGame(){
		//Initial instriction are printed to the console
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");

		//prints the empty board to the console
		board.printBoard(human.getPiece(), computer.getPiece());

		//Declares win and draw booleans and sets them to false when the game begins
		boolean win = false;
		boolean draw = false;

		//while the game has not been won or drawn, both players continue to take turns
		while(!win && !draw){

			//If the board is full then the game is a draw and it ends
			if (board.isBoardFull()){
				System.out.println("No Spaces left, it is a draw!");
				draw=true;
				continue;
			}

			//a move is taken from player 1 as an input, only empty columns are valid
			int move = human.takeInput(board.emptySpaceColumns);

			//the counter is placed in the desired column
			board.placeCounter(human,move);

			//the new board with the placed counter is printed
			board.printBoard(human.getPiece(), computer.getPiece());

			//if the player won with their move then the game is finished
			if(board.checkForWin(human.getPiece())){
				win = true;
				System.out.println(String.format("%s Has Won!!!",human.getName()));
				continue;

			}

			//If the board is full then the game is a draw and it ends
			if (board.isBoardFull()){
				System.out.println("No Spaces left, it is a draw!");
				draw=true;
				continue;
			}

			//the move is taken from the computer
			move = computer.takeInput(board.emptySpaceColumns);

			//the counter is placed in the desired column
			board.placeCounter(computer, move);

			//the new board with the placed counter is printed
			board.printBoard(human.getPiece(), computer.getPiece());

			//if the computer won with their move then the game is finished
			if(board.checkForWin(computer.getPiece())){
				win = true;
				System.out.println(String.format("%s Has Won!!!",computer.getName()));
				continue;
			}

		}
	}
}
