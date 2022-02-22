package domain;

import exception.Notification;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;


/**
 * 입출금 내역
 */
public class BankTransaction {

	private final LocalDate date;
	private final double amount;
	private final String description;

	public LocalDate getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public BankTransaction(LocalDate date, double amount, String description) {
		this.date = date;
		this.amount = amount;
		this.description = description;
	}

	public static Notification validate(String description, String date, String amount) {
		final Notification notification = new Notification();
		if (description.length() > 100) {
			notification.addError("Too long");
		}
		final LocalDate parsedDate;
		try {
			parsedDate = LocalDate.parse(date);
			if (parsedDate.isAfter(LocalDate.now())) {
				notification.addError("date cannot be in the future");
			}
		} catch (DateTimeParseException e) {
			notification.addError("Invalid format for date");
		}

		final double amountDouble;
		try {
			amountDouble = Double.parseDouble(amount);
		} catch (NumberFormatException e) {
			notification.addError("Invalid format for amount");
		}
		return notification;
	}

	@Override
	public String toString() {
		return "BankTransaction{" +
				"date=" + date +
				", amount=" + amount +
				", description='" + description + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BankTransaction that = (BankTransaction) o;
		return Double.compare(that.amount, amount) == 0 && Objects.equals(date,
				that.date) && Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, amount, description);
	}
}
