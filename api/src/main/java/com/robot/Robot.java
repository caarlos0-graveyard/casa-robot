package com.robot;

import com.robot.exception.InvalidRobotCommandException;
import com.robot.exception.RobotOutOfBoundsException;

/**
 * The Robot!
 *
 * @author carlos
 */
public class Robot {

    private RobotPosition position;

    public Robot() {
        this.position = RobotPosition.initialPosition();
    }

    /**
     * Move the robot according to the given commands.
     *
     * @param commands MLR formated string
     * @return the position after move.
     * @throws InvalidRobotCommandException if an invalid command is given
     * @throws RobotOutOfBoundsException    if robot gets out of the field
     */
    public String move(String commands) {
        for (char command : commands.toCharArray())
            process(command);
        if (!position.isValid())
            throw new RobotOutOfBoundsException(commands, position);
        return position.toString();
    }

    /**
     * Processes a given Robot Command.
     *
     * @param command
     * @throws InvalidRobotCommandException
     */
    private void process(char command) {
        if (command == 'M')
            position.forward();
        else if ("RL".indexOf(command) > -1)
            position.rotate(command);
        else
            throw new InvalidRobotCommandException(command);
    }
}
