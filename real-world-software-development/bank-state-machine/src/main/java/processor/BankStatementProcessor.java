package processor;

import domain.BankTransaction;
import filter.BankTransactionFilter;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankStatementProcessor {

	public double summarizeTransactions(List<BankTransaction> bankTransactions,
			final BankTransactionSummarizer bankTransactionSummarizer) {
		double result = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			result = bankTransactionSummarizer.summarize(result, bankTransaction);
		}
		return result;
	}

	public double calculateTotalInMonth(List<BankTransaction> bankTransactions,
			Month month) {
		return summarizeTransactions(bankTransactions, (acc, bankTransaction) ->
				bankTransaction.getDate().getMonth() == month
						? acc + bankTransaction.getAmount()
						: acc
		);
	}

	public double calculateTotalForCategory(List<BankTransaction> bankTransactions,
			final String category) {
		return summarizeTransactions(bankTransactions, (acc, bankTransaction) ->
				Objects.equals(bankTransaction.getDescription(), category)
						? acc + bankTransaction.getAmount()
						: acc
		);
	}

	public double calculateTotalAmount(List<BankTransaction> bankTransactions) {
		return summarizeTransactions(bankTransactions, (acc, bankTransaction) ->
				acc + bankTransaction.getAmount()
		);
	}

	/**
	 * 암묵적 API BankTransactionFilter 인터페이스를 이용해 중복 로직(for-loop)과 비즈니스 로직의 결합도를 낮춘다.
	 * OCP : 변경 없이도 확장성은 개방된다. (bankTransactionFilter 구현체를 통해)
	 * TODO Stream 으로 변경
	 */
	public List<BankTransaction> findTransactions(List<BankTransaction> bankTransactions, final
	BankTransactionFilter bankTransactionFilter) {
		final List<BankTransaction> result = new ArrayList<>();
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransactionFilter.test(bankTransaction)) {
				result.add(bankTransaction);
			}
		}
		return result;
	}

	/**
	 * 명시적 API
	 */
	public List<BankTransaction> findTransactionGreaterThanEqual(
			List<BankTransaction> bankTransactions, final int amount) {
		return findTransactions(bankTransactions,
				bankTransaction -> bankTransaction.getAmount() >= amount);
	}
}
