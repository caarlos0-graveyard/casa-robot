package com.robot.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robot.WindRose;

/**
 * Tests the WindRose class.
 * 
 * @author carlos
 */
public class WindRoseTests {

	private WindRose rose(char pointedTo) {
		return new WindRose(pointedTo);
	}

	@Test
	public void starting_from_n_left_rotate() {
		assertEquals('W', rose('N').getSibling('L'));
	}

	@Test
	public void starting_from_n_right_rotate() {
		assertEquals('E', rose('N').getSibling('R'));
	}

	@Test
	public void starting_from_e_left_rotate() {
		assertEquals('N', rose('E').getSibling('L'));
	}

	@Test
	public void starting_from_e_right_rotate() {
		assertEquals('S', rose('E').getSibling('R'));
	}

	@Test
	public void starting_from_s_left_rotate() {
		assertEquals('E', rose('S').getSibling('L'));
	}

	@Test
	public void starting_from_s_right_rotate() {
		assertEquals('W', rose('S').getSibling('R'));
	}

	@Test
	public void starting_from_w_left_rotate() {
		assertEquals('S', rose('W').getSibling('L'));
	}

	@Test
	public void starting_from_w_right_rotate() {
		assertEquals('N', rose('W').getSibling('R'));
	}
}
