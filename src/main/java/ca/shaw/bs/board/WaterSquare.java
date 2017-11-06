package ca.shaw.bs.board;

public class WaterSquare implements IGridSquare {

	String gridValue = GridSquareValue.WATER.getValue();
	boolean squareHit = false;
	
	@Override
	public String getGridValue() {
		return this.gridValue;
	}

	@Override
	public void targetSquare() {
		//if this square hasn't been targeted before then set it to a miss
		if(!this.squareHit)
		{
			this.gridValue = GridSquareValue.MISS.getValue();
			this.squareHit = true;
		}
		else
		{
			//Do nothing
		}
	}
}
