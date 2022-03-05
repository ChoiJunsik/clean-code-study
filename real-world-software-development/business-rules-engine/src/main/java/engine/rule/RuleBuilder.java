package engine.rule;

import engine.Action;
import engine.Condition;

public class RuleBuilder {

	private Condition condition;
	private Action action;

	public RuleBuilder when(final Condition condition) {
		this.condition = condition;
		return this;
	}

	public RuleBuilder then(final Action action) {
		this.action = action;
		return this;
	}

	public Rule build() {
		return new DefaultRule(condition, action);
	}
}
