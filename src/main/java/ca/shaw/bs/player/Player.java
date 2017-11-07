package ca.shaw.bs.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


import ca.shaw.bs.board.AlignmentType;
import ca.shaw.bs.board.Board;
import ca.shaw.bs.board.grid.GridSquareValue;


public class Player {
	
	private String id; 
	private Board board;
	private BufferedReader reader = null;
	private int hitsLeft = 3;
	private static final String COMMAND_SEPERATOR = "-----------------------------------------------------------------------------------";
	
	public Player(String id) throws UnsupportedEncodingException {
		this.id = id;
		this.board = new Board();
		this.reader = new BufferedReader(new InputStreamReader(System.in, "UTF8"));
	}

	public String getId() {
		return id;
	}
	
	public void setBufferedReader(BufferedReader reader)
	{
		this.reader = reader;
	}
	
	
    public BufferedReader bufferedReader() throws UnsupportedEncodingException {
        return new BufferedReader(new InputStreamReader(System.in, "UTF8"));
    }

	public void placeShip() throws IOException
	{
		String alignment = "";
		boolean validAlignment = false;
		String column = "";
		String row = "";
		
		promptBuilder("STARTING GAME - PLAYER " + this.id);
		board.printBoard();
		promptBuilder("PLAYER " + this.id + "- Please place your ship ");

		//Prompt User for valid alignment input
		while(!validAlignment){
			promptBuilder("Please enter how you would like to align your ship: Vertical (V), Horizontal (H)");
			
			if ((alignment = this.reader.readLine()) != null)		
				validAlignment = validAlignmentType(alignment);
		}
		promptBuilder("Please enter coordinate for your ship to be placed: <Letter (Column)> <Number (Row)>");
		
		String line;
		if((line = reader.readLine()) != null){
			String[] params = line.split(" ");
		    column = params[0];
			row = params[1];
		}
				
		board.placeShipsOnBoard(alignment, column, row);
		board.printBoard();
	}
	
	public void attack(Player opponent) throws IOException
	{
		String column = "";
		String row = "";
		promptBuilder("ATTACK - PLAYER " + this.id);

		opponent.board.printBoard();
		//Prompt user for attack coordinates
		promptBuilder("Player " + this.id + " Please enter your attack coordinates <Letter (Column)> <Number (Row)> ");
	
		String line;
		if((line = reader.readLine()) != null){
			String[] params = line.split(" ");
		    column = params[0];
			row = params[1];
		}
	
		//Shoot and check the result
		if(opponent.board.shootAtBoard(column, row).equals(GridSquareValue.HIT.name()))
			opponent.opponentHit();

	}
	
	public boolean validAlignmentType(String align)
	{
		boolean isValid = false;
		
		if(align.equals(AlignmentType.VERTICAL.getValue()) || align.equals(AlignmentType.HORIZONTAL.getValue()))
			isValid = true;
		
		return isValid;
	}

	public boolean isDead() {
		boolean isDead = false;
		
		if(hitsLeft == 0)
			isDead = true;
		
		return isDead;
	}
	
	public void opponentHit()
	{
		if(hitsLeft > 0)
			hitsLeft--;
	}
	
	private void promptBuilder(String message)
	{
		System.out.println(COMMAND_SEPERATOR);
		System.out.println(message);
		System.out.println(COMMAND_SEPERATOR);
	}

}
