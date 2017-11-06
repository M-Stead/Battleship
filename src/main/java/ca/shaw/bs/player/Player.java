package ca.shaw.bs.player;

import java.util.Scanner;

import ca.shaw.bs.board.AlignmentType;
import ca.shaw.bs.board.Board;

public class Player {
	
	private String id; 
	private Board board;
	private Scanner scanner;
	
	public Player(String id) {
		this.id = id;
		this.board = new Board();
		this.scanner = new Scanner(System.in);
	}

	public String getId() {
		return id;
	}

	
	public void placeShip()
	{
		String alignment = "";
		boolean validAlignment = false;
		String column = "";
		String row = "";
		System.out.println("%n Player " + this.id + "- Please place your ships %n");
		//Prompt User for valid alignment input

		while(!validAlignment)
		{
			//Prompt user for command line input
			System.out.println("Please enter how you would like to align your ship: Vertical (V), Horizontal (H)");
			alignment = this.scanner.nextLine();
			
			validAlignment = validAlignmentType(alignment);
		}
		
		System.out.println("Please enter coordinate for your ship to be placed: <Letter (Column)>  <Number (Row)> ");
		
		while(this.scanner.hasNext())
		{
			 column = this.scanner.next();
			 row = this.scanner.next();
			
		}
		
		board.placeShipsOnBoard(alignment, column, row);
	}
	
	
	public boolean validAlignmentType(String align)
	{
		boolean isValid = false;
		
		if(align.equals(AlignmentType.VERTICAL.getValue())|align.equals(AlignmentType.HORIZONTAL.getValue()))
			isValid = true;
		
		return isValid;
	}

}
