import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonsterTest {
	private static int initX, initY, Speed;
	private static Monster monster;
	
	@BeforeAll
	static void setup() {
		initX = 10;
		initY = 10;
	    Speed=5;
	}

	@Test
	void testhidden() {

		monster = new Monster(initX, initY, Speed);
		// Actions
		monster.hidden();

		boolean actualhidden = monster.getHidden();

		// Expected Results
		boolean expecthidden = true;

		// Assertions
		assertEquals(expecthidden, actualhidden);

	}

	@Test
	void testunhid() {

		monster = new Monster(initX, initY, Speed);

		// Actions
		monster.unhid();
		boolean actualunhid = monster.getHidden();

		// Expected Results
		boolean expectunhid = false;

		// Assertions
		assertEquals(expectunhid, actualunhid);

	}

}
