package com.robot;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.robot.rest.MarsResource;

/**
 * The Robot JAX-RS Application
 * 
 * @author carlos
 */
public class RobotApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MarsResource.class);
		return classes;
	}
}
