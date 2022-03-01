package domain.importer;

import static domain.attributes.Attributes.HEIGHT;
import static domain.attributes.Attributes.PATH;
import static domain.attributes.Attributes.WIDTH;
import static domain.attributes.Attributes.TYPE;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import port.in.Importer;

public class ImageImporter implements Importer {

	@Override
	public Document importFile(File file) throws IOException {
		final Map<String, String> attributes = new HashMap<>();
		attributes.put(PATH, file.getPath());

		final BufferedImage image = ImageIO.read(file);
		attributes.put(WIDTH, String.valueOf(image.getWidth()));
		attributes.put(HEIGHT, String.valueOf(image.getHeight()));
		attributes.put(TYPE, "IMAGE");

		return new Document(attributes);
	}
}
