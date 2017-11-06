package ca.shaw.bs.game;



import ca.shaw.bs.board.Board;
import ca.shaw.bs.player.Player;

public class Game
{
	 private Player[] players;

	    public Game() {

	        this.players = new Player[]{
	                new Player("One"),
	                new Player("Two")
	        };
	    }


	public void start() {
		
	//Initialize Board
	Board board = new Board();
	}
}
