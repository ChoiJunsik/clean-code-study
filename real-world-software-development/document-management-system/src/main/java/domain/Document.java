package domain;

import java.util.Map;

public class Document {
	// 상속 vs 조합
	private final Map<String, String> attributes;

	public Document(final Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}
}
