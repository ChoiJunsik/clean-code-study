package object_create_pattern.abstract_factory;

import object_create_pattern.factory_method.HumanoidRobotFactory;
import object_create_pattern.factory_method.RobotFactory;
import object_create_pattern.factory_method.WarRobotFactory;
import object_create_pattern.factory_method.robot.Robot;

public class CheckPartsClient {

	public static void main(String[] args) {

		CheckPartsClient checkPartsClient = new CheckPartsClient();

		checkPartsClient.print(new WarRobotFactory(new LowPricePartsFactory()),"junsik1", "junsik1@choi.com");
		checkPartsClient.print(new HumanoidRobotFactory(new HighPricePartsFactory()),"junsik2", "junsik2@choi.com");
	}

	private void print(RobotFactory robotFactory, String name, String email) {
		Robot robot = robotFactory.orderRobot(name, email);
		System.out.println("robot.getMetal().getClass() = " + robot.getMetal().getClass());
		System.out.println("robot.getNetworkModule().getClass() = " + robot.getNetworkModule().getClass());
	}
}
