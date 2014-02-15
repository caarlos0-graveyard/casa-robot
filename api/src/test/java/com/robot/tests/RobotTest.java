package com.robot.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.robot.Robot;
import com.robot.exception.InvalidRobotCommandException;
import com.robot.exception.RobotOutOfBoundsException;

/**
 * Tests the Robot class.
 */
public class RobotTest {

	private Robot robot = null;

	@Before
	public void init() {
		robot = new Robot();
	}

	@Test
	public void it_should_return_the_default_position_when_no_arguments_are_given()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("00N", robot.move(""));
	}

	@Test
	public void it_should_rotate_to_right()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("00E", robot.move("R"));
	}

	@Test
	public void it_should_rotate_to_right_and_overlap()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("00E", robot.move("RRRRR"));
	}

	@Test
	public void it_should_rotate_to_left() throws InvalidRobotCommandException,
	        RobotOutOfBoundsException {
		assertEquals("00W", robot.move("L"));
	}

	@Test
	public void it_should_rotate_to_left_and_overlap()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("00W", robot.move("LLLLL"));
	}

	@Test
	public void it_should_move_forward() throws InvalidRobotCommandException,
	        RobotOutOfBoundsException {
		assertEquals("02N", robot.move("MM"));
	}

	@Test
	public void it_should_move_forward_and_turn()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("02W", robot.move("MML"));
	}

	@Test
	public void it_should_move_forward_turn_and_move()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("11E", robot.move("MRM"));
	}

	@Test
	public void it_should_do_complex_movimentation()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("13N", robot.move("MRMLMM"));
	}

	@Test
	public void it_should_loop_in_the_field()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		assertEquals("00W", robot.move("MMRMMRMMRMM"));
	}

	@Test(expected = RobotOutOfBoundsException.class)
	public void it_should_crash_when_out_of_bounds_n()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		robot.move("MMMMMM");
	}

	@Test(expected = RobotOutOfBoundsException.class)
	public void it_should_crash_when_out_of_bounds_w()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		robot.move("LM");
	}

	@Test(expected = RobotOutOfBoundsException.class)
	public void it_should_crash_when_out_of_bounds_s()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		robot.move("RRM");
	}

	@Test(expected = RobotOutOfBoundsException.class)
	public void it_should_crash_when_out_of_bounds_e()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		robot.move("RMMMMMM");
	}

	@Test(expected = InvalidRobotCommandException.class)
	public void it_should_crash_when_a_invalid_command_is_given()
	        throws InvalidRobotCommandException, RobotOutOfBoundsException {
		robot.move("MLSM");
	}
}
