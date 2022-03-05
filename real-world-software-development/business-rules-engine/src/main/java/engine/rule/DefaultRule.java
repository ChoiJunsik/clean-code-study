package engine.rule;

import engine.Action;
import engine.Condition;
import engine.Facts;

public class DefaultRule implements Rule {

	private final Condition condition;
	private final Action action;

	public DefaultRule(final Condition condition, final Action action) {
		this.action = action;
		this.condition = condition;
	}

	@Override
	public void perform(final Facts facts) {
		if (condition.evaluate(facts)) {
			action.perform(facts);
		}
	}
}
