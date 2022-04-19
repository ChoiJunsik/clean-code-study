package object_create_pattern.builder;

import java.util.List;

public class TourPlan {

	private String title;
	private String whereToStay;
	private int nights;
	private int day;
	private List<DetailPlan> plans;

	public TourPlan(String title, String whereToStay, int nights, int day, List<DetailPlan> plans) {
		this.title = title;
		this.whereToStay = whereToStay;
		this.nights = nights;
		this.day = day;
		this.plans = plans;
	}
}
