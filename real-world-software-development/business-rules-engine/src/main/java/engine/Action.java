package engine;

@FunctionalInterface
public interface Action {

	void perform(final Facts facts);
}
