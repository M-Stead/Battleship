package ca.shaw.bs.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ca.shaw.bs.board.AlignmentType;
import ca.shaw.bs.board.Board;
import ca.shaw.bs.board.GridSquareValue;

public class Player {
	
	private String id; 
	private Board board;
	private BufferedReader reader;
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

	
	public void placeShip() throws IOException
	{
		String alignment = "";
		boolean validAlignment = false;
		String column = "";
		String row = "";
		System.out.println(COMMAND_SEPERATOR);
		System.out.println("STARTING GAME - PLAYER " + this.id);
		System.out.println(COMMAND_SEPERATOR);
		this.board.printBoard();
		System.out.println(COMMAND_SEPERATOR);
		System.out.println("PLAYER " + this.id + "- Please place your ship ");
		//Prompt User for valid alignment input

		while(!validAlignment)
		{
			//Prompt user for command line input
			System.out.println(COMMAND_SEPERATOR);
			System.out.println("Please enter how you would like to align your ship: Vertical (V), Horizontal (H)");
			
			
				String readAlignment;
				if ((readAlignment = this.reader.readLine()) != null)
				{
					alignment = readAlignment;
				}
			
				
			validAlignment = validAlignmentType(alignment);
		}
		System.out.println(COMMAND_SEPERATOR);
		System.out.println("Please enter coordinate for your ship to be placed: <Number (Row)> <Letter (Column)>");
		System.out.println(COMMAND_SEPERATOR);
		
		String line;
		if((line = reader.readLine()) != null)
		{
			String[] params = line.split(" ");
		    column = params[0];
			row = params[1];
		}
		
					
		board.placeShipsOnBoard(alignment, row, column);
		board.printBoard();
	}
	
	public void attack() throws IOException
	{
		String column = "";
		String row = "";
		System.out.println(COMMAND_SEPERATOR);
		System.out.println("ATTACK - PLAYER " + this.id);
		System.out.println(COMMAND_SEPERATOR);
		board.printBoard();
		//Prompt user for attack coordinates
		System.out.println(COMMAND_SEPERATOR);
		System.out.println("Player " + this.id + "Please enter your attack coordinates <Number (Row)> <Letter (Column)>");
	
		String line;
		if((line = reader.readLine()) != null)
		{
			String[] params = line.split(" ");
		    column = params[0];
			row = params[1];
		}
	
		//Shoot and check the result
		if(this.board.shootAtBoard(row, column).equals(GridSquareValue.HIT.name()))
		{
			this.hitsLeft--;
		}

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
		
		if(this.hitsLeft == 0)
			isDead = true;
		
		return isDead;
	}

}
