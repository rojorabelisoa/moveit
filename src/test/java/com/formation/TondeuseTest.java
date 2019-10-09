package com.formation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TondeuseTest {

	@Test
	public void setUp() {
		Tondeuse ref = new Tondeuse(1, 3, Direction.NORTH);
		assertEquals(1, ref.getX());
		assertEquals(3, ref.getY());
		assertEquals("NORTH", ref.getDirection().name());
	}

	@Test(expected = NullPointerException.class)
	public void setUpNullValue() {
		new Tondeuse(1, 3, null);
	}

	@Test(expected = NumberFormatException.class)
	public void setUpNegValue() {
		new Tondeuse(-1, -3, Direction.NORTH);
	}

	@Test
	public void useCase1() {
		Tondeuse t = new Tondeuse(1, 2, Direction.NORTH);
		assertEquals(new Tondeuse(1, 3, Direction.NORTH), TondeuseHelper.moveWithActions(t, "GAGAGAGAA"));
	}

	@Test
	public void useCase2()  {
		Tondeuse mower = new Tondeuse(3, 3, Direction.EAST);
		assertEquals(new Tondeuse(5, 1, Direction.EAST), TondeuseHelper.moveWithActions(mower, "AADAADADDA"));
	}


}
