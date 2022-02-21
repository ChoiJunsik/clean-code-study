package filter;

import domain.BankTransaction;
import java.time.Month;

public class bankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

	@Override
	public boolean test(BankTransaction bankTransaction) {
		return bankTransaction.getDate().getMonth() == Month.FEBRUARY
				&& bankTransaction.getAmount() >= 1_000;
	}
}
