package com.robot.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.robot.exception.InvalidRobotCommandException;
import com.robot.exception.RobotException;

/**
 * Maps the {@link InvalidRobotCommandException}
 * 
 * @author carlos
 * 
 */
@Provider
public class RobotExceptionMapper implements ExceptionMapper<RobotException> {

	@Override
	public Response toResponse(RobotException exception) {
		return Response.status(Status.BAD_REQUEST)
				.entity(exception.getMessage()).build();
	}

}
