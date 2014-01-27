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
	private char pointedTo;

	public RobotPosition(int x, int y, char pointedTo) {
		this.x = x;
		this.y = y;
		this.pointedTo = pointedTo;
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
		return isSideValid(x) && isSideValid(y);
	}

	/**
	 * changes the x value by the specified amount.
	 * 
	 * @param amount
	 */
	public void changeXBy(int amount) {
		x = x + amount;
	}

	/**
	 * change the y value by the specified amount.
	 * 
	 * @param amount
	 */
	public void changeYBy(int amount) {
		y = y + amount;
	}

	/**
	 * Rotate 90º in its own axis to the given side
	 * 
	 * @param side
	 */
	public void rotate(char side) {
		WindRose rose = new WindRose(pointedTo);
		pointedTo = rose.getSibling(side);
	}

	private boolean isSideValid(int side) {
		return side < Constants.SIZE && side >= 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getPointedTo() {
		return pointedTo;
	}

	@Override
	public String toString() {
		return "" + x + y + pointedTo;
	}
}
