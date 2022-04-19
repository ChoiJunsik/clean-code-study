package object_create_pattern.builder;

public class App {

	public static void main(String[] args) {
		TourPlanBuilder builder = new DefaultTourBuilder();
		TourPlan tourPlan = builder.title("seoul")
				.nightsAndDays(2, 3)
				.whereToStay("mokdong")
				.addPlan(0, "check in")
				.addPlan(1, "go to omokgyo")
				.getPlan();

		System.out.println("tourPlan = " + tourPlan);
	}
}
