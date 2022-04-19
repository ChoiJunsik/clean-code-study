package object_create_pattern.prototype;

public class App {

	public static void main(String[] args) throws CloneNotSupportedException {
		GithubRepository repository = new GithubRepository();
		repository.setUser("junsik");
		repository.setName("design-patterns");

		GithubIssue githubIssue = new GithubIssue(repository);
		githubIssue.setId(1);
		githubIssue.setTitle("prototype pattern");

		GithubIssue clone = (GithubIssue) githubIssue.clone();
		System.out.println(clone != githubIssue);
		System.out.println(clone.equals(githubIssue));
		System.out.println(clone.getClass() == githubIssue.getClass());
		// shallow copy
		System.out.println(clone.getRepository() == githubIssue.getRepository());
	}
}
