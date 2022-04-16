package object_create_pattern.factory_method;

import object_create_pattern.abstract_factory.RobotPartsFactory;
import object_create_pattern.factory_method.robot.HumanoidRobot;
import object_create_pattern.factory_method.robot.Robot;

public class HumanoidRobotFactory implements RobotFactory {

	private final RobotPartsFactory robotPartsFactory;

	public HumanoidRobotFactory(
			RobotPartsFactory robotPartsFactory) {
		this.robotPartsFactory = robotPartsFactory;
	}

	@Override
	public Robot createRobot() {
		/**
		 * Business Logic can be appended
		 */
		Robot robot = new HumanoidRobot();
		robot.setMetal(robotPartsFactory.createMetal());
		robot.setNetworkModule(robotPartsFactory.createNetworkModule());

		return robot;
	}
}
