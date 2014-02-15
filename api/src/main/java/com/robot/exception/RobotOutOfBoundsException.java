package com.robot.exception;

import com.robot.RobotPosition;

/**
 * This exception is thrown when the Robot walks too far and gets out of the
 * Field.
 * 
 * @author carlos
 * 
 */
public class RobotOutOfBoundsException extends RobotException {
    private static final long serialVersionUID = 1L;

    public RobotOutOfBoundsException(String givenCommand,
            RobotPosition wrongPosition) {
        super("The command [" + givenCommand
                + "] couldn't be executed because it will be out of bounds ("
                + wrongPosition.toFormattedString() + ").");
    }
}
