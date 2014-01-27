package com.robot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.robot.tests.RobotPositionTests;
import com.robot.tests.RobotTests;
import com.robot.tests.WindRoseTests;

/**
 * Suite of all Robot tests.
 * 
 * @author carlos
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = { RobotTests.class, WindRoseTests.class,
		RobotPositionTests.class })
public class AllRobotTests {

}
