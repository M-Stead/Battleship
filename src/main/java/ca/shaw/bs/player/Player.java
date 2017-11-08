package ca.shaw.bs.player;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.shaw.bs.board.AlignmentType;
import ca.shaw.bs.board.Board;
import ca.shaw.bs.board.grid.GridSquareValue;

@Configuration
public class Player {
	
	private String id = "0"; 
	private Board board;
	private int hitsLeft = 3;
	private BufferedReader reader;
	
	private static String COMMAND_SEPERATOR = "--------------------------------------------------------------------------";
	

	
	public Player(String id) throws UnsupportedEncodingException {
		this.id = id;
		this.board = new Board();
		this.reader = reader();

	}
	
	@Bean
    protected BufferedReader reader() throws UnsupportedEncodingException {
        return new BufferedReader(new InputStreamReader(System.in, "UTF8"));
    }

	public String getId() {
		return id;
	}
	

	public void placeShip() throws IOException
	{
		String alignment = null;
		boolean validAlignment = false;
		String[] params = null;
		
		promptBuilder("STARTING GAME - PLAYER " + this.id);
		board.printBoard();
		promptBuilder("PLAYER " + this.id + "- Please place your ship ");

		//Prompt User for valid alignment input
		while(!validAlignment){
			promptBuilder("Please enter how you would like to align your ship: Vertical (V), Horizontal (H)");		
		
			if ((alignment = this.reader.readLine()) != null)		
				validAlignment = validAlignmentType(alignment);
		}
		
		params = grabCommandLineCoordinates();
				
		board.placeShipsOnBoard(alignment,  params[0], params[1]);
		board.printBoard();
	}
	
	public void attack(Player opponent) throws IOException
	{
		String[] params = null;
		promptBuilder("ATTACK - PLAYER " + this.id);

		opponent.board.printBoard();

		promptBuilder("Player " + this.id + " Ready to Attack ");
	
		params = grabCommandLineCoordinates();
	
		//Shoot and check the result
		if(opponent.getBoard().shootAtBoard(params[0], params[1]).equals(GridSquareValue.HIT.name()))
			opponent.opponentHit();

	}
	
	protected String[] grabCommandLineCoordinates() throws IOException
	{
		promptBuilder(" Please enter your attack coordinates <Letter (Column)> <Number (Row)> ");
		String[] params = null;
		String line = "";
		if((line = reader.readLine()) != null){
			params = line.split(" ");
		}
	
		return params;
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
	
	public Board getBoard()
	{
		return this.board;
	}
	
	private void promptBuilder(String message)
	{
		System.out.println(COMMAND_SEPERATOR);
		System.out.println(message);
		System.out.println(COMMAND_SEPERATOR);
	}

}
