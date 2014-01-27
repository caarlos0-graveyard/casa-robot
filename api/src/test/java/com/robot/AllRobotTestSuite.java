package com.robot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.robot.tests.RobotPositionTest;
import com.robot.tests.RobotTest;
import com.robot.tests.WindRoseTest;

/**
 * Suite of all Robot tests.
 * 
 * @author carlos
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = { RobotTest.class, WindRoseTest.class,
		RobotPositionTest.class })
public class AllRobotTestSuite {

}
