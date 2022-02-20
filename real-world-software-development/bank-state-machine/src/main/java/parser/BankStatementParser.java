package parser;

import domain.BankTransaction;
import java.util.List;

/**
 * 결합도 낮추기
 */
public interface BankStatementParser {

	BankTransaction parseFrom(String line);

	List<BankTransaction> parseLinesFrom(List<String> lines);
}
