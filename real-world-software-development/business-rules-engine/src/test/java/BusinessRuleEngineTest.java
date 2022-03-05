import static org.junit.jupiter.api.Assertions.*;

import engine.Action;
import engine.BusinessRuleEngine;
import engine.Condition;
import engine.Facts;
import engine.rule.DefaultRule;
import engine.rule.Rule;
import engine.rule.RuleBuilder;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BusinessRuleEngineTest {

	@Test
	void shouldHaveNoRulesInitially() {
		final Facts mockFacts = mock(Facts.class);

		final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

		assertEquals(0, businessRuleEngine.count());
	}

	@Test
	public void shouldPerformAnActionWithFacts() {
		final Facts facts = new Facts();
		facts.addFact("jobTitle", "CEO");
		facts.addFact("name", "Choi");

		final Condition condition = pFacts -> "CEO".equals(pFacts.getFact("jobTitle"));
		final Action action = pFacts -> {
			var name = pFacts.getFact("name");
			System.out.println("Action Trigger");
		};

		final Rule rule = mock(DefaultRule.class);

		final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);

		businessRuleEngine.addRule(rule);

		businessRuleEngine.run();

		verify(rule).perform(facts);
	}
}
