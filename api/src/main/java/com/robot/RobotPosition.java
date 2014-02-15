package com.robot;

/**
 * Represents a possible Robot Position
 * 
 * @author carlos
 * 
 */
public class RobotPosition {
	private int x;
	private int y;
	private char direction;
	private final WindRose rose;

	public RobotPosition(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.rose = new WindRose();
	}

	/**
	 * Return the default initial robot position (00N).
	 * 
	 * @return a robot position which represents 00N
	 */
	public static RobotPosition initialPosition() {
		return new RobotPosition(0, 0, 'N');
	}

	/**
	 * checks whether a position is valid.
	 * 
	 * @return true if position is valid, false otherwise.
	 */
	public boolean isValid() {
		return isAxisValid(x) && isAxisValid(y);
	}

	/**
	 * Rotate 90º in its own axis to the given side
	 * 
	 * @param side
	 */
	public void rotate(char side) {
		direction = rose.getSibling(direction, side);
	}

	/**
	 * Move one position forward.
	 */
	public void moveForward() {
		/*
		 * when its pointed to N or S, change Y by amount, in other cases change
		 * X.
		 */
		if ("NS".indexOf(direction) > -1) {
			y = y + amountToChange();
		} else {
			x = x + amountToChange();
		}
	}

	/**
	 * Calculates the amount of rows to walk
	 * 
	 * @return 1 or -1
	 */
	private int amountToChange() {
		/*
		 * when its pointed to N or E, increase the axis value by one, in other
		 * cases decrease by one.
		 */
		return "NE".indexOf(direction) > -1 ? 1 : -1;
	}

	/**
	 * checks if the given axis value is valid (< LIMIT && > -1)
	 * 
	 * @param axis
	 *            x or y values
	 * @return true if ok, false otherwise.
	 */
	private boolean isAxisValid(int axis) {
		return axis < Constants.SIZE && axis >= 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "" + x + y + direction;
	}

	/**
	 * @return the position in 0,0,N format
	 */
	public String toFormattedString() {
		return x + "," + y + "," + direction;
	}
}
