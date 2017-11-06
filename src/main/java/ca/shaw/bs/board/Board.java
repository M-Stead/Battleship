package ca.shaw.bs.board;

public class Board {
	
	private IGridSquare[][] board;
	private int shipSize = 3;
	
	public Board() {
		constructBoard(BoardLetters.values().length);
	}
	
	public void constructBoard(int boardSize)
	{
		this.board = new IGridSquare[boardSize][boardSize];
		
		//Populate board with water
		for (int i = 0; i < boardSize; i++)
		{
			for (int j = 0; j < boardSize; j++)
				this.board[i][j] = new WaterSquare();
		}
	}
	
	public void printBoard()
	{
		for(BoardLetters letter: BoardLetters.values())
		{
			System.out.print("   " + letter.name() );
		}
		System.out.println("");
		
		//Print Grid
		for (int i = 0; i < BoardLetters.values().length; i++)
		{
			System.out.print(i+1);
			for (int j = 0; j < BoardLetters.values().length; j++)
				System.out.print("   " + this.board[i][j].getGridValue()); 
			System.out.println("");
		}
	}
	
	public void placeShipsOnBoard(String alignment, String column, String row)
	{
		int xCoordinate = BoardLetters.valueOf(column).getValue();
		int yCoordinate = Integer.parseInt(row);
		//Assess coordinates (Are they valid)? 
		if(validatePlacementCoordinates(alignment, xCoordinate, yCoordinate))
		{
		
			//Once validated place ship
			if(alignment.equals(AlignmentType.VERTICAL.getValue()))
			{
				for(int i= xCoordinate; i < (xCoordinate+shipSize);i++)
					board[i][yCoordinate] = new ShipSquare();
			}
			else if(alignment.equals(AlignmentType.HORIZONTAL.getValue()))
			{
				for(int j= yCoordinate; j < (yCoordinate+shipSize);j++)
					board[xCoordinate][j] = new ShipSquare();
			}
			else
			{
				//Invalid
			}
		}
		else
		{
			System.out.println("Invalid Coordinates passed in for ship placement. Ship not placed");
		}
		
	}
	
	public boolean validatePlacementCoordinates(String alignment, int xCoord, int yCoord)
	{
		boolean result = false;
		if(alignment.equals(AlignmentType.HORIZONTAL.getValue()))
		{
			if(xCoord < (BoardLetters.values().length - shipSize)) 
				result = true;
		}
		else if(alignment.equals(AlignmentType.VERTICAL.getValue()))
		{
			if(yCoord < (BoardLetters.values().length - shipSize)) 
				result = true;
		}
		else
		{
			
		}
		return result;
	}
	
	public IGridSquare[][] getBoard()
	{
		return this.board;
	}

}
