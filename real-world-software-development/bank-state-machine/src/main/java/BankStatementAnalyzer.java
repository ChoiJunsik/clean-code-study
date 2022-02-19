import domain.BankTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import parser.BankStatementCSVParser;
import processor.BankStatementProcessor;

public class BankStatementAnalyzer {

	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		final String fileName = args[0];
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = BankStatementCSVParser.parseLinesFromCSV(
				lines);

		collectSummary(bankTransactions);
	}

	private static void collectSummary(List<BankTransaction> bankTransactions) {
		System.out.println(
				"The Total for all transactions is " + BankStatementProcessor.calculateTotalAmount(
						bankTransactions));
		System.out.println(
				"The Total for all transactions in January is"
						+ BankStatementProcessor.calculateTotalInMonth(
						bankTransactions,
						Month.JANUARY));
		System.out.println(
				"The Total for all transactions in February is"
						+ BankStatementProcessor.calculateTotalInMonth(
						bankTransactions,
						Month.FEBRUARY));
		System.out.println("The total salary received is "
				+ BankStatementProcessor.calculateTotalForCategory(bankTransactions, "Salary"));
	}
}
