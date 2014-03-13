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
	public static final List<Character> CARDEAL_POINTS = Arrays.asList( 'N',
			'E', 'S', 'W' );

	/**
	 * Return the direct sibling in the specified side.
	 * 
	 * @param direction
	 * @return
	 */
	public char getSibling(char point, char direction) {
		return CARDEAL_POINTS.get( fixPositionOverlap( getNextPosition( direction,
				indexOf( point ) ) ) );
	}

	/**
	 * get the index of a given cardeal point in the CARDEAL_POINTS List.
	 * 
	 * @param cardealPoint
	 * @return
	 */
	private int indexOf(char cardealPoint) {
		return CARDEAL_POINTS.indexOf( cardealPoint );
	}

	/**
	 * Fixes the overlap in the index, i.e., do the loop from the end of the
	 * WIND_ROSE List back to the beginning and vice-versa, or just return the
	 * actual index if it doesn't apply.
	 * 
	 * @param index
	 *            current index
	 * @return overlaped index
	 */
	private int fixPositionOverlap(int index) {
		if (index == -1) {
			return 3;
		}
		if (index == 4) {
			return 0;
		}
		return index;
	}

	/**
	 * Given the index to begin from and a side to walk, get the next cardeal
	 * point.
	 * 
	 * @param direction
	 *            L or R, representing Left or Right: the side to walk
	 * @param index
	 *            the current WIND_ROSE List index.
	 * @return the new WIND_ROSE List index.
	 */
	private int getNextPosition(char direction, int index) {
		if (direction == 'L') {
			return index - 1;
		}
		return index + 1;
	}
}
