package processor;

import domain.BankTransaction;
import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

	public static double calculateTotalInMonth(List<BankTransaction> bankTransactions,
			Month month) {
		double total = 0d;

		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	public static double calculateTotalForCategory(List<BankTransaction> bankTransactions,
			final String category) {
		double total = 0d;

		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
		double total = 0d;

		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
}
