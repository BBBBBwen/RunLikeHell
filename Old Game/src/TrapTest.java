import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TrapTest {
	private static int initXCor, initYCor;
	private static Trap trap;

	@BeforeAll
	static void setup() {
		initXCor = 10;
		initYCor = 10;
	}

	@Test
	void testDecTime() {
		trap = new Trap(initXCor, initYCor);

		// Actions
		trap.decTime();

		// Actual Results
		int actualTime = trap.getTime();

		// Expected Results
		int expectedTime = 9;

		// Assertions
		assertEquals(expectedTime, actualTime);
	}

	@Test
	void testDeactivate() {
		trap = new Trap(initXCor, initYCor);

		// Actions
		trap.deactivate();

		// Actual Results
		boolean actualState = trap.getState();

		// Expected Results
		boolean expectedState = false;

		// Assertions
		assertEquals(actualState, expectedState);
	}

}
