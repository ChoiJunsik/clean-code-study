import static java.util.stream.Collectors.toMap;

import importer.Document;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

public class Query implements Predicate<Document> {

	private final Map<String, String> clauses;

	public static Query parse(final String query) {
		return new Query(Arrays.stream(query.split(","))
				.map(str -> str.split(":"))
				.collect(toMap(q -> q[0], q -> q[1])));
	}

	public Query(Map<String, String> clauses) {
		this.clauses = clauses;
	}

	@Override
	public boolean test(final Document document) {
		return clauses.entrySet()
				.stream()
				.allMatch(entry -> {
					final String documentValue = document.getAttribute(entry.getKey());
					final String queryValue = entry.getValue();
					return documentValue != null && documentValue.contains(queryValue);
				});
	}
}
