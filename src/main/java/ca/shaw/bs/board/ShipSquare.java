package ca.shaw.bs.board;

public class ShipSquare implements IGridSquare {

	private String gridValue = GridSquareValue.BOAT.getValue();
	private boolean squareHit = false;
	private String gridResult = GridSquareValue.MISS.name();
	
	@Override
	public String getGridValue() {
		return this.gridValue;
	}
	
	@Override
	public String getGridResult(){
		return this.gridResult;
	}
	
	@Override
	public boolean getSquareHit() {
		
		return this.squareHit;
	}

	@Override
	public void targetSquare() {
		//if this square hasn't been targeted before then set it to a miss
		if(!squareHit)
		{
			this.gridValue = GridSquareValue.HIT.getValue();
			this.gridResult = GridSquareValue.HIT.name();
			this.squareHit = true;
		}
		else
		{
			System.out.println("Square has already been targeted");
		}
	}
	
}
