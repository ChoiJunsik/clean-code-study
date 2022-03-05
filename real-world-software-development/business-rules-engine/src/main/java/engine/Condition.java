package engine;

@FunctionalInterface
public interface Condition {
	boolean evaluate(final Facts facts);
}
