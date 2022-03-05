import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BusinessRuleEngineTest {
	final Facts mockFacts = mock(Facts.class);

	@Test
	void shouldHaveNoRulesInitially() {

		final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

		assertEquals(0, businessRuleEngine.count());
	}

	@Test
	void shouldAddTwoActions() {
		final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

		businessRuleEngine.addAction(facts -> {
		});
		businessRuleEngine.addAction(facts -> {
		});

		assertEquals(2, businessRuleEngine.count());
	}

	@Test
	void shouldExecuteOneAction() {
		// given
		final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);
		final Action mockAction = mock(Action.class);
		// when
		businessRuleEngine.addAction(mockAction);
		businessRuleEngine.run();
		// then
		verify(mockAction).perform(mockFacts);
	}

	@Test
	public void shouldPerformAnActionWithFacts() {
		final Action mockAction = mock(Action.class);
		final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

		businessRuleEngine.addAction(mockAction);
		businessRuleEngine.run();

		verify(mockAction).perform(mockFacts);
	}
}
