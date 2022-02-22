package parser;

import domain.BankTransaction;
import exception.Notification;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import exception.CSVSyntaxException;

public class BankStatementCSVParser implements BankStatementParser {

	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final int EXPECTED_ATTRIBUTES_LENGTH = 3;

	@Override
	public BankTransaction parseFrom(String line) {
		final String[] columns = line.split(",");

		if (columns.length < EXPECTED_ATTRIBUTES_LENGTH) {
			throw new CSVSyntaxException();
		}

		Notification validated = BankTransaction.validate(columns[0], columns[1], columns[2]);

		if (validated.hasErrors()) {
			throw new CSVSyntaxException();
		}

		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];

		return new BankTransaction(date, amount, description);
	}

	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		final List<BankTransaction> bankTransactions = new ArrayList<>();
		for (final String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
	}
}
