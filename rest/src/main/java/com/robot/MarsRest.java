package com.robot;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.robot.exception.InvalidRobotCommandException;
import com.robot.exception.RobotOutOfBoundsException;

/**
 * Mars Robot REST interface
 * 
 * @author carlos
 * 
 */
@Path("/mars")
public class MarsRest {

	/**
	 * Moves the according to the given commands.
	 * 
	 * @param commands
	 *            MLR commands
	 * @return the position of robot after moving
	 * @throws InvalidRobotCommandException
	 *             if an invalid command is given
	 * @throws RobotOutOfBoundsException
	 *             if the robot walks too much and gets out of the field
	 */
	@POST
	@Path("/{commands}")
	public Response move(@PathParam("commands") String commands)
			throws InvalidRobotCommandException, RobotOutOfBoundsException {
		return Response.status(200).entity(new Robot().move(commands)).build();
	}
}
