package ca.shaw.bs.board;

public class Board {
	
	//Board
	private IGridSquare[][] board;
	private static final String[] BOARD_LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H"};
	
	public Board() {
		constructBoard(BOARD_LETTERS.length);
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
		for(String letter: BOARD_LETTERS)
		{
			System.out.print("   " + letter );
		}
		System.out.println("");
		
		//Print Grid
		for (int i = 0; i < BOARD_LETTERS.length; i++)
		{
			System.out.print(i);
			for (int j = 0; j < BOARD_LETTERS.length; j++)
				System.out.print("   " + this.board[i][j].getGridValue()); 
			System.out.println("");
		}
	}
	
	public void placeBoatsOnBoard(GridSquareValue action)
	{
		
	}

}
