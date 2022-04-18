package object_create_pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class DefaultTourBuilder implements TourPlanBuilder {
    private String title;
    private String whereToStay;
    private int nights;
    private int days;
    private List<DetailPlan> plans = new ArrayList<>();

    @Override
    public TourPlanBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        this.nights = nights;
        this.days = days;
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.whereToStay = whereToStay;
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int days, String plan) {
        this.plans.add(new DetailPlan(days, plan));
        return this;
    }

    @Override
    public TourPlan getPlan() {
        return new TourPlan(title, whereToStay, nights, days, plans);
    }
}
