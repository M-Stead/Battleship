package ca.shaw.bs.game;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import ca.shaw.bs.player.Player;

public class Game
{
	 private Player[] players;

	    public Game() throws UnsupportedEncodingException {
	        this.players = new Player[]{new Player("One"), new Player("Two")};
	    }

	public void play() throws IOException {
		
		//Prompt players to place ships on the board on the first turn
		for(Player player: players)
		{
			player.placeShip();
		}
		
		//Prompt players for Shots
		while((!players[0].isDead()) && (!players[1].isDead()))
		{
			players[0].attack();
			
			if(!players[0].isDead())
				players[1].attack();
		}
		
		//Once the boat has been sunk then end game with message 
		System.out.println("You've Sunk My Battleship!");
	}
}
