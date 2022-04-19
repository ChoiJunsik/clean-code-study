package object_create_pattern.builder;

public interface TourPlanBuilder {

	TourPlanBuilder title(String title);

	TourPlanBuilder nightsAndDays(int nights, int days);

	TourPlanBuilder whereToStay(String whereToStay);

	TourPlanBuilder addPlan(int days, String plan);

	TourPlan getPlan();
}
