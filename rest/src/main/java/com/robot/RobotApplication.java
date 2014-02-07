package com.robot;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.robot.exceptions.RobotExceptionMapper;
import com.robot.rest.MarsResource;

/**
 * The Robot JAX-RS Application
 * 
 * @author carlos
 */
@ApplicationPath("/")
public class RobotApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MarsResource.class);
		classes.add(RobotExceptionMapper.class);
		return classes;
	}
}
