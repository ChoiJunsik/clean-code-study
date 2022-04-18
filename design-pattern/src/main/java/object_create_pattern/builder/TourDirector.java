package object_create_pattern.builder;

/**
 * Director : 반복되는 패턴의 모음
 */
public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan omokgyoTour() {
        return tourPlanBuilder.title("seoul")
                .nightsAndDays(2, 3)
                .whereToStay("mokdong")
                .addPlan(0, "check in")
                .addPlan(1, "go to omokgyo")
                .getPlan();
    }
}
