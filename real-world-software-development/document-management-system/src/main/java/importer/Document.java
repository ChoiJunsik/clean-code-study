package domain.importer;

import java.util.Map;

public class Document {

	/** 상속 vs 조합
	 * Map을 상속 받는다 => 비즈니스와 관계 없는 get 같은 메소드로 Document 도메인에 접근 가능.
	 * 또한 비즈니스의 변경에 유연한 변경이 불가능해진다.
	 */
	private final Map<String, String> attributes;

	Document(final Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getAttribute(String key) {
		return attributes.get(key);
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}
}
