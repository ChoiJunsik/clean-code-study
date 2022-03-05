package engine;

import engine.rule.Rule;
import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
	private final List<Rule> rules;
	private final Facts facts;

	public BusinessRuleEngine(Facts facts) {
		this.facts = facts;
		this.rules = new ArrayList<>();
	}

	public void addRule(final Rule rule) {
		this.rules.add(rule);
	}

	public int count() {
		return this.rules.size();
	}

	public void run() {
		this.rules.forEach(rule -> rule.perform(facts));
	}
}
