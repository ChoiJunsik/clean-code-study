package port.in;

import importer.Document;
import java.io.File;
import java.io.IOException;

public interface Importer {
	// String (x) => File (강한 형식의 원칙, 오류 발생 범위를 줄인다)
	Document importFile(File file) throws IOException;
}
