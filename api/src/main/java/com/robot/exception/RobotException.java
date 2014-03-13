package com.robot.exception;

/**
 * Encapsulates Robot Exceptions.
 * 
 * @author carlos
 * 
 */
public abstract class RobotException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RobotException(String msg) {
		super( msg );
	}

}
