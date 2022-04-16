package object_create_pattern.factory_method;

import object_create_pattern.factory_method.robot.Robot;

public interface RobotFactory {

	default Robot orderRobot(String name, String email) {
		validate(name, email);
		prepareFor(name);
		/**
		 * Factory Pattern Core,
		 * Factory 클래스 상속을 통해, Client 코드(createRobot) 변화 없이 구체 클래스를 생성할 수 있다
 		 */
		Robot robot = createRobot();
		sendEmailTo(email, robot);
		return robot;
	}

	private void sendEmailTo(String email, Robot robot) {
		System.out.println(robot.getName() + " is created, send to " + email);
	}

	Robot createRobot();

	private void prepareFor(String name) {
		System.out.println("RobotFactory.prepareFor " + name);
	}

	private void validate(String name, String email) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("No name");
		}

		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("No email");
		}
	}
}
