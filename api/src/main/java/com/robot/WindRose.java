package com.robot;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the WindRose and is able to discover some cardeal point sibling.
 * 
 * @author carlos
 * 
 */
public class WindRose {
	public static List<Character> CARDEAL_POINTS = Arrays.asList('N', 'E', 'S',
			'W');

	public WindRose() {
	}

	/**
	 * Return the direct sibling in the specified side.
	 * 
	 * @param direction
	 * @return
	 */
	public char getSibling(char point, char direction) {
		return CARDEAL_POINTS.get(fixPositionOverlap(getNextPosition(direction,
				indexOf(point))));
	}

	private int indexOf(char point) {
		return CARDEAL_POINTS.indexOf(point);
	}

	private int fixPositionOverlap(int index) {
		if (index == -1)
			return 3;
		if (index == 4)
			return 0;
		return index;
	}

	private int getNextPosition(char direction, int index) {
		if (direction == 'L')
			return index - 1;
		return index + 1;
	}
}
