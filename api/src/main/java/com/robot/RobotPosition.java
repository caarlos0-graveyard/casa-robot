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

	public RobotPosition(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
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
	 * Rotate 90º in its own axis to the given side
	 * 
	 * @param side
	 */
	public void rotate(char side) {
		WindRose rose = new WindRose(direction);
		direction = rose.getSibling(side);
	}
	
	/**
	 * Move one position forward.
	 */
	public void forward() {
		int amount = "NE".indexOf(direction) > -1 ? 1 : -1;
		if ("NS".indexOf(direction) > -1)
			y = y + amount;
		else
			x = x + amount;
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
