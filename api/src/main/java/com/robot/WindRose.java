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
	private char point;

	public WindRose(char point) {
		this.point = point;
	}

	/**
	 * Return the direct sibling in the specified side.
	 * 
	 * @param side
	 * @return
	 */
	public char getSibling(char side) {
		int index = getNextPosition(side, CARDEAL_POINTS.indexOf(point));
		return CARDEAL_POINTS.get(fixPositionOverlap(index));
	}

	private int fixPositionOverlap(int index) {
		if (index == -1)
			return 3;
		if (index == 4)
			return 0;
		return index;
	}

	private int getNextPosition(char side, int index) {
		if (side == 'L')
			return index - 1;
		return index + 1;
	}
}
