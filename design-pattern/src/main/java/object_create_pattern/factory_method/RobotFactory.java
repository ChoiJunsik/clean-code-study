package object_create_pattern.factory_method;

public interface RobotFactory {
	default Robot orderRobot(String name, String email) {
		validate(name, email);
		prepareFor(name);
		Robot robot = createRobot();
		sendEmailTo(email, robot);
		return robot;
	}

	private void sendEmailTo(String email, Robot robot) {
		System.out.println(robot.getName() + "RobotFactory.sendEmailTo");
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
