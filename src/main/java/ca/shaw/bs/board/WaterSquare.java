package ca.shaw.bs.board;

public class WaterSquare implements IGridSquare {

	private String gridValue = GridSquareValue.WATER.getValue();
	private boolean squareHit = false;
	private String gridResult = GridSquareValue.WATER.name();
	
	@Override
	public String getGridValue() {
		return this.gridValue;
	}
	
	@Override
	public String getGridResult() {
		return this.gridResult;
	}
	
	@Override
	public boolean getSquareHit() {
		
		return this.squareHit;
	}


	@Override
	public void targetSquare() {
		//if this square hasn't been targeted before then set it to a miss
		if(!this.squareHit)
		{
			this.gridValue = GridSquareValue.MISS.getValue();
			this.squareHit = true;
			this.gridResult = GridSquareValue.MISS.name();
		}
		else
		{
			System.out.println("Square has already been targeted");
		}
	}
}
