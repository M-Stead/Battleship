package ca.shaw.bs.board;

public class WaterSquare implements IGridSquare {

	String gridValue = GridSquareValue.WATER.value();
	
	
	@Override
	public String getGridValue() {
		return this.gridValue;
	}

	@Override
	public void targetSquare() {
		// TODO Auto-generated method stub
		
	}

}
