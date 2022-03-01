import importer.Document;
import importer.ImageImporter;
import importer.InvoiceImporter;
import importer.LetterImporter;
import importer.ReportImporter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import port.in.Importer;

public class DocumentManagementSystem {

	private final Map<String, Importer> extensionToImporter = new HashMap<>();
	private final List<Document> documents = new ArrayList<>();
	private final List<Document> documentsView = Collections.unmodifiableList(documents);

	public DocumentManagementSystem() {
		extensionToImporter.put("letter", new LetterImporter());
		extensionToImporter.put("report", new ReportImporter());
		extensionToImporter.put("jpg", new ImageImporter());
		extensionToImporter.put("invoice", new InvoiceImporter());
	}

	// path (String) 사용한 이유, import 할 파일의 형식이 구체화되지않음
	public void importFile(final String path) throws IOException {
		final File file = new File(path);
		if (!file.exists()) {
			throw new FileNotFoundException(path);
		}

		final int separatorIndex = path.lastIndexOf('.');
		if (separatorIndex != -1) {
			if (separatorIndex == path.length()) {
				throw new UnknownFileTypeException("No Extension found For file: " + path);
			}

			final String extension = path.substring(separatorIndex + 1);
			final Importer importer = extensionToImporter.get(extension);
			if (importer == null) {
				throw new UnknownFileTypeException("For file: " + path);
			}

			final Document document = importer.importFile(file);
			documents.add(document);
		} else {
			throw new UnknownFileTypeException("No Extension found For file: " + path);
		}

	}

	public List<Document> contents() {
		return documentsView;
	}

	public List<Document> search(final String query) {
		return documents.stream()
				.filter(Query.parse(query))
				.collect(Collectors.toList());
	}
}
