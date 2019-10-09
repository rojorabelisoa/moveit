package com.formation;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void getPrevTest() {
		assertEquals(Direction.WEST, Direction.NORTH.getPrevious());
		assertEquals(Direction.SOUTH, Direction.WEST.getPrevious());
		assertEquals(Direction.EAST, Direction.SOUTH.getPrevious());
		assertEquals(Direction.NORTH, Direction.EAST.getPrevious());
	}

	@Test
	public void getNextTest() {
		assertEquals(Direction.EAST, Direction.NORTH.getNext());
		assertEquals(Direction.NORTH, Direction.WEST.getNext());
		assertEquals(Direction.WEST, Direction.SOUTH.getNext());
		assertEquals(Direction.SOUTH, Direction.EAST.getNext());
	}

	@Test
	public void parseTest() {
		assertEquals(Direction.EAST, Direction.parse('E'));
		assertEquals(Direction.EAST, Direction.parse("E"));
		assertEquals(Direction.EAST, Direction.parse("e"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseInvalidValueTest() {
		Direction.parse("P");
	}

}
