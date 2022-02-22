package exporter;

import domain.SummaryStatistics;

public interface Exporter {

	String export(SummaryStatistics summaryStatistics);
}
