package importer;

import static attributes.Attributes.PATH;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TextFile {
	private final Map<String, String> attributes;
	private final List<String> lines;

	TextFile(final File file) throws IOException {
		attributes = new HashMap<>();
		attributes.put(PATH, file.getPath());
		lines = Files.lines(file.toPath()).collect(Collectors.toList());
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	int addLines(
			final int start,
			final Predicate<String> isEnd,
			final String attributeName) {

		final StringBuilder accumulator = new StringBuilder();
		int lineNumber;
		for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
			final String line = lines.get(lineNumber);
			if (isEnd.test(line)) {
				break;
			}

			accumulator.append(line);
			accumulator.append("\n");
		}
		attributes.put(attributeName, accumulator.toString().trim());
		return lineNumber;
	}

	void addLineSuffix(final String prefix, final String attributeName) {
		for(final String line: lines) {
			if (line.startsWith(prefix)) {
				attributes.put(attributeName, line.substring(prefix.length()));
				break;
			}
		}
	}
}
