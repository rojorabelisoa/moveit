package com.formation;

import java.util.Objects;

public class Tondeuse {
	private int x;
	private int y;
	private Direction direction;

	public Tondeuse(int x, int y, Direction direction) {
		if (x < 0 || y < 0) {
			throw new NumberFormatException("valeur x et y doivent être supétieur à 0");
		}
		Objects.requireNonNull(direction);
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Tondeuse(String x, String y, String direction) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);
		Objects.requireNonNull(direction);
		this.x = Integer.valueOf(x);
		this.y = Integer.valueOf(y);
		this.direction = Direction.parse(direction);
	}

	public void moveLeft() {
		this.direction = this.direction.getPrevious();
	}

	public void moveRigth() {
		this.direction = this.direction.getNext();
	}

	public void moveWithActions(String instruction) {
		// parse orders
		Action[] actions = new Action[instruction.length()];
		for (int i = 0; i < instruction.length(); i++) {
			actions[i] = Action.parse(instruction.charAt(i));
		}
		// for each orders, make the action
		for (Action action : actions) {
			action.move(this);
		}
	}

	public void moveForward() {
		switch (this.direction) {
		case NORTH:
			this.y = y + 1;
			break;
		case EAST:
			this.x = x + 1;
			break;
		case SOUTH:
			this.y = y - 1;
			break;
		case WEST:
			this.x = x - 1;
			break;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tondeuse other = (Tondeuse) obj;
		if (direction != other.direction)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tondeuse [x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}


}
