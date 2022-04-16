package object_create_pattern.factory_method;

import object_create_pattern.abstract_factory.RobotPartsFactory;
import object_create_pattern.factory_method.robot.Robot;
import object_create_pattern.factory_method.robot.WarRobot;

public class WarRobotFactory implements RobotFactory {

	private final RobotPartsFactory robotPartsFactory;

	public WarRobotFactory(
			RobotPartsFactory robotPartsFactory) {
		this.robotPartsFactory = robotPartsFactory;
	}

	@Override
	public Robot createRobot() {
		/**
		 * Business Logic can be appended
		 */
		Robot robot = new WarRobot();
		robot.setMetal(robotPartsFactory.createMetal());
		robot.setNetworkModule(robotPartsFactory.createNetworkModule());
		return robot;
	}
}
