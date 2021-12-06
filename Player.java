public abstract class Player {

    private char playerPiece;
    private char oppPiece;


    // Player super class which just sets the attributes for the children classes
    public Player(char playerPiece, char oppPiece){
        this.playerPiece = playerPiece;
        this.oppPiece = oppPiece;

    }

    // getters for both the player piece and opponenet piece
    public char getPlayerPiece(){ return this.playerPiece; }
    public char getOppPiece(){ return this.oppPiece; }



}
