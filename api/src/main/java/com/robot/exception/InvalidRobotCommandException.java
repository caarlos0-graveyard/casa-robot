package com.robot.exception;

/**
 * This exception is thrown when a invalid command is given to the Robot.
 *
 * @author carlos
 *
 */
public class InvalidRobotCommandException extends RobotException {
	private static final long serialVersionUID = 1L;

	public InvalidRobotCommandException(char givenCommand) {
		super("The command '" + givenCommand
				+ "' is invalid. Must contain only 'M', 'L' and 'R' letters.");
	}
}
