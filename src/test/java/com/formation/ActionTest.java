package com.formation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActionTest {

	@Test
	public void parseTest() {
		assertEquals(Action.AVANCE, Action.parse('A'));
		assertEquals(Action.AVANCE, Action.parse("A"));
		assertEquals(Action.AVANCE, Action.parse("A"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseInvalidValueTest() {
		Action.parse('S');
	}

}
