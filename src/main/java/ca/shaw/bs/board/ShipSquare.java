package ca.shaw.bs.board;

public class ShipSquare implements IGridSquare {

	String gridValue = GridSquareValue.BOAT.getValue();
	boolean squareHit = false;
	
	@Override
	public String getGridValue() {
		return this.gridValue;
	}

	@Override
	public void targetSquare() {
		//if this square hasn't been targeted before then set it to a miss
		if(!squareHit)
		{
			this.gridValue = GridSquareValue.HIT.getValue();
			this.squareHit = true;
		}
		else
		{
			//Do nothing
		}
	}
}
