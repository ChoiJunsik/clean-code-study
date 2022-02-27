import domain.Document;
import domain.importer.ImageImporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import port.in.Importer;

public class DocumentManagementSystem {

	private final Map<String, Importer> extensionToImporter = new HashMap<>();

	public DocumentManagementSystem() {
//		extensionToImporter.put("letter", new LetterImporter());
//		extensionToImporter.put("report", new ReportImporter());
		extensionToImporter.put("jpg", new ImageImporter());
	}

	public void importFile(String path) {

	}

	public List<Document> contents() {
		return null;
	}
}
