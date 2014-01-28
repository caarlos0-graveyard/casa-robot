package com.robot.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.robot.Robot;
import com.robot.exception.InvalidRobotCommandException;
import com.robot.exception.RobotOutOfBoundsException;

/**
 * Mars Robot REST interface
 * 
 * @author carlos
 * 
 */
@Path("/mars")
public class MarsResource {

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
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{commands}")
	public Response move(@PathParam("commands") String commands)
			throws InvalidRobotCommandException, RobotOutOfBoundsException {
		final String position = new Robot().move(commands);
		return Response.status(Status.OK).entity(position).build();
	}
}
