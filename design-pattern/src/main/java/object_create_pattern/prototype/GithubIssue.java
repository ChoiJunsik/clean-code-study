package object_create_pattern.prototype;

import java.util.Objects;

public class GithubIssue implements Cloneable {

	private int id;
	private String title;
	private GithubRepository repository;

	public GithubIssue(GithubRepository repository) {
		this.repository = repository;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRepository(GithubRepository repository) {
		this.repository = repository;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public GithubRepository getRepository() {
		return repository;
	}

	/**
	 * Shallow Copy
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GithubIssue that = (GithubIssue) o;
		return id == that.id && Objects.equals(title, that.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}
}
