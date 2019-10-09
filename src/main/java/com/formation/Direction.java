package com.formation;

public enum Direction {
	NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

	private final char value;
	private Direction next;
	private Direction previous;

	Direction(final char val) {
		value = val;
	}

	static {
		NORTH.next = EAST;
		EAST.next = SOUTH;
		SOUTH.next = WEST;
		WEST.next = NORTH;
		NORTH.previous = WEST;
		EAST.previous = NORTH;
		SOUTH.previous = EAST;
		WEST.previous = SOUTH;
	}
	/***
	   * Initialise la valeur de l'orientation avec un entrée de char
	   * @param value valeur de la tondeuse
	   * @return l'orientation de la tondeuse
	   * @throws IllegalArgumentException si le parametre ne correspond pas à la valeur d'action existante
	   */
	public static Direction parse(char value) throws IllegalArgumentException {
		for (int i =0;i<Direction.values().length;i++) {
			if (value == Direction.values()[i].value) {
				return Direction.values()[i];
			}
		}
		throw new IllegalArgumentException(String.format("Valeur de direction inconnu: '%s'", value));
	}
	/***
	   * Initialise la valeur de l'orientation avec un entrée de String
	   * @param value valeur de la tondeuse
	   * @return l'orientation de la tondeuse
	   * @throws IllegalArgumentException si le parametre ne correspond pas à la valeur d'action existante
	   */
	public static Direction parse(String val) throws IllegalArgumentException {
		return parse(val.toUpperCase().charAt(0));
	}

	public Direction getNext() {
		return next;
	}

	public void setNext(Direction next) {
		this.next = next;
	}

	public Direction getPrevious() {
		return previous;
	}

	public void setPrevious(Direction previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
