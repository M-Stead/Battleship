package ca.shaw.bs.board.grid;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WaterSquareTest {

	WaterSquare testWaterSquare;
	
	@Before
	public void setUp() throws Exception {
		this.testWaterSquare =  new WaterSquare();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void targetSquare_NotHitBefore() {
		assertEquals(GridSquareValue.WATER.name(), this.testWaterSquare.getGridResult());
		assertEquals(GridSquareValue.WATER.getValue(), this.testWaterSquare.getGridValue());
		assertFalse(this.testWaterSquare.getSquareHit());
		
		this.testWaterSquare.targetSquare();
		
		assertEquals(GridSquareValue.MISS.name(), this.testWaterSquare.getGridResult());
		assertEquals(GridSquareValue.MISS.getValue(), this.testWaterSquare.getGridValue());
		assertTrue(this.testWaterSquare.getSquareHit());
	}

}
