package engine.rule;

import engine.Facts;

@FunctionalInterface
public interface Rule {
	void perform(final Facts facts);
}

