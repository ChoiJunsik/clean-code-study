package object_create_pattern.factory_method;

public class HumanoidRobotFactory implements RobotFactory{

	@Override
	public Robot createRobot() {
		/**
		 * Business Logic can be appended
		 */
		return new HumanoidRobot();
	}
}
