package com.robot.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.robot.WindRose;

/**
 * Tests the WindRose class.
 * 
 * @author carlos
 */
public class WindRoseTest {

	private WindRose rose;

	@Before
	public void init() {
		rose = new WindRose();
	}

	@Test
	public void starting_from_n_left_rotate() {
		assertEquals('W', rose.getSibling('N', 'L'));
	}

	@Test
	public void starting_from_n_right_rotate() {
		assertEquals('E', rose.getSibling('N', 'R'));
	}

	@Test
	public void starting_from_e_left_rotate() {
		assertEquals('N', rose.getSibling('E', 'L'));
	}

	@Test
	public void starting_from_e_right_rotate() {
		assertEquals('S', rose.getSibling('E', 'R'));
	}

	@Test
	public void starting_from_s_left_rotate() {
		assertEquals('E', rose.getSibling('S', 'L'));
	}

	@Test
	public void starting_from_s_right_rotate() {
		assertEquals('W', rose.getSibling('S', 'R'));
	}

	@Test
	public void starting_from_w_left_rotate() {
		assertEquals('S', rose.getSibling('W', 'L'));
	}

	@Test
	public void starting_from_w_right_rotate() {
		assertEquals('N', rose.getSibling('W', 'R'));
	}
}
