package ca.shaw.bs.board;

public enum AlignmentType {
	HORIZONTAL("H"),
	VERTICAL("V");
	
	private String value;
	
	AlignmentType(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}

}
