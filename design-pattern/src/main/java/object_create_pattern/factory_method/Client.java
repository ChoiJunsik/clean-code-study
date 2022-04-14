package object_create_pattern.factory_method;

public class Client {

	public static void main(String[] args) {

		Client client = new Client();

		client.print(new WarRobotFactory(),"junsik1", "junsik1@choi.com");
		client.print(new HumanoidRobotFactory(),"junsik2", "junsik2@choi.com");
	}

	private void print(RobotFactory robotFactory, String name, String email) {
		System.out.println(robotFactory.orderRobot(name, email));
	}
}

/**
 * Factory Method Pattern
 * OCP, 기존 인스턴스 생성 코드를 건드리지 않고, 같은 종류의 새로운 인스턴스를 생성시 변경 없이 확장 가능
 */
