package ca.shaw.bs.game;


import ca.shaw.bs.player.Player;

public class Game
{
	 private Player[] players;

	    public Game() {
	        this.players = new Player[]{new Player("One"), new Player("Two")};
	    }

	public void start() {
		
		//Prompt players to place ships on the board on the first turn
		for(Player player: players)
		{
			player.placeShip();
		}
		
		//Prompt players for Shots
		
		//Once the boat has been sunk then end game with message 
	}
}
