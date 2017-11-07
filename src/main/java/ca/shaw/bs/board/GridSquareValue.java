package ca.shaw.bs.board;

public enum GridSquareValue {

	
	    INVALID("I"),
		WATER("~"),
	    BOAT("B"),
	    MISS("O"),
	    HIT("X"),
	    SUNK("X");
	
	private String value;
	
	GridSquareValue(String value){
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
}
