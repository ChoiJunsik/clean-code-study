package parser;

import domain.BankTransaction;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankStatementCSVParserTest {

	private final BankStatementParser parser = new BankStatementCSVParser();

	@Test
	public void shouldParseOneCorrectLine() throws Exception {
		// Given
		final String line = "22-02-2022,-50,Tesla";
		// When
		final BankTransaction result = parser.parseFrom(line);
		// Then
		final BankTransaction expected = new BankTransaction(LocalDate.of(2022, Month.FEBRUARY, 22),
				-50, "Tesla");
		final double tolerance = 0.0d;

		Assertions.assertEquals(expected.getDate(), result.getDate());
		Assertions.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		Assertions.assertEquals(expected.getDescription(), result.getDescription());
	}

}