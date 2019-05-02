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
	void testMoveUp() {

		monster = new Monster(initX, initY, Speed);

		// Actions
		monster.moveUp(1);

		// Actual Results
		int actualX = monster.getX();
		int actualY = monster.getY();

		// Expected Results
		int expectedX = 10;
		int expectedY = 9;

		// Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);

	}

	@Test
	void testMoveDown() {

		monster = new Monster(initX, initY, Speed);

		// Actions
		monster.moveDown(1);

		// Actual Results
		int actualX = monster.getX();
		int actualY = monster.getY();

		// Expected Results
		int expectedX = 10;
		int expectedY = 11;

		// Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);

	}

	@Test
	void testMoveLeft() {

		monster = new Monster(initX, initY, Speed);

		// Actions
		monster.moveLeft(1);

		// Actual Results
		int actualX = monster.getX();
		int actualY = monster.getY();

		// Expected Results
		int expectedX = 9;
		int expectedY = 10;

		// Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);

	}

	@Test
	void testMoveRight() {

		monster = new Monster(initX, initY, Speed);

		// Actions
		monster.moveRight(1);

		// Actual Results
		int actualX = monster.getX();
		int actualY = monster.getY();

		// Expected Results
		int expectedX = 11;
		int expectedY = 10;

		// Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);

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
