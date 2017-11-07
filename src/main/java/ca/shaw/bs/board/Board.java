package ca.shaw.bs.board;

public class Board {
	
	private IGridSquare[][] board;
	private int shipSize = 3;
	
	public Board() {
		constructBoard(BoardLetters.values().length);
	}
	
	protected void constructBoard(int boardSize)
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
			System.out.println(" ");
			System.out.println(" ");
		}
	}
	
	public void placeShipsOnBoard(String alignment, String column, String row)
	{
		int xCoordinate = BoardLetters.valueOf(column).getValue();
		int yCoordinate = Integer.parseInt(row) - 1;
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
	
	protected boolean validatePlacementCoordinates(String alignment, int xCoord, int yCoord)
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
	
	public  String shootAtBoard(String column, String row)
	{
		
		int xCoordinate = BoardLetters.valueOf(column).getValue();
		int yCoordinate = Integer.parseInt(row);
		String result = "";
		
		if ( validateShootingCoordinate(xCoordinate,yCoordinate ))
		{
			if ( !this.board[xCoordinate][yCoordinate].getSquareHit())
			{
				this.board[xCoordinate][yCoordinate].targetSquare();
				result = this.board[xCoordinate][yCoordinate].getGridResult();
				System.out.println("HIT - Good Shot");
			}else{
				System.out.println("MISS - Please Try Again");
			}
		}
		else
		{
			System.out.println("Please enter a validate coordinate to target");
			result = GridSquareValue.INVALID.name();
		}
		
		return result;
	}
	
	protected boolean validateShootingCoordinate(int x, int y)
	{
		boolean isValid = false;
		
		if (( (x >= 0) && (x < BoardLetters.values().length)) && ( (y >= 0) && (y < BoardLetters.values().length)))
			isValid = true;
		
		return isValid;
	}
	
	public boolean hasItBeenShot(int x, int y)
	{
		boolean hasItBeenShot = false;
		
		if (((x >= 0) && (x < BoardLetters.values().length)) && ( (y >= 0) && (y < BoardLetters.values().length)))
			hasItBeenShot = true;
		
		return hasItBeenShot;
	}
	
	protected IGridSquare[][] getBoard()
	{
		return board;
	}

}
