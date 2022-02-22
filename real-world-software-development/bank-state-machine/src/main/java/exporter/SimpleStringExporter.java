package exporter;

import domain.SummaryStatistics;

public class SimpleStringExporter implements Exporter{

	@Override
	public String export(SummaryStatistics summaryStatistics) {
		return summaryStatistics.toString();
	}
}
