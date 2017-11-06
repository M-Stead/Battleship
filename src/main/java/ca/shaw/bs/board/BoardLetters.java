package ca.shaw.bs.board;

public enum BoardLetters {
	
	A(0),
	B(1),
	C(2),
	D(3),
	E(4),
	F(5),
	G(6),
	H(7);
	

	BoardLetters(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	private int value;

}
