package engine;

public interface ConditionalAction {
	boolean evaluate(final Facts facts);
	void perform(final Facts facts);
}
