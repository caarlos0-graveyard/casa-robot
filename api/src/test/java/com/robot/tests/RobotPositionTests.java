package com.robot.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.robot.RobotPosition;

/**
 * Tests the RobotPosition class.
 * 
 * @author carlos
 * 
 */
public class RobotPositionTests {

	private RobotPosition position;

	@Before
	public void init() {
		position = RobotPosition.initialPosition();
	}

	@Test
	public void isValid_should_return_true() {
		assertEquals(true, position.isValid());
	}

	@Test
	public void x_should_be_0() {
		assertEquals(0, position.getX());
	}

	@Test
	public void y_should_be_0() {
		assertEquals(0, position.getY());
	}

	@Test
	public void it_should_increment_x() {
		position.changeXBy(1);
		assertEquals(1, position.getX());
	}

	@Test
	public void it_should_increment_y() {
		position.changeYBy(1);
		assertEquals(1, position.getY());
	}

	@Test
	public void it_should_decrement_x() {
		position.changeXBy(-1);
		assertEquals(-1, position.getX());
	}

	@Test
	public void it_should_decrement_y() {
		position.changeYBy(-1);
		assertEquals(-1, position.getY());
	}

	@Test
	public void it_should_rotate_to_left() {
		position.rotate('L');
		assertEquals('W', position.getPointedTo());
	}

	@Test
	public void it_should_rotate_to_right() {
		position.rotate('R');
		assertEquals('E', position.getPointedTo());
	}
}
