import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PlayerTest {
	private static int initXCor, initYCor, initEnergy, initEnergyMore;
	private static Player player;
	
	@BeforeAll
	static void setup() {
		initXCor = 10;
		initYCor = 10;
		initEnergy = 40;
		initEnergyMore = 100;
	}

	@Test
	void testMoveUp() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.moveUp(1);
		
		//Actual Results
		int actualX = player.getX();
		int actualY = player.getY();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedX = 10;
		int expectedY = 9;
		int expectedEnergy = 38;
		
		//Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testMoveDown() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.moveDown(1);
		
		//Actual Results
		int actualX = player.getX();
		int actualY = player.getY();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedX = 10;
		int expectedY = 11;
		int expectedEnergy = 38;
		
		//Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testMoveLeft() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.moveLeft(1);
		
		//Actual Results
		int actualX = player.getX();
		int actualY = player.getY();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedX = 9;
		int expectedY = 10;
		int expectedEnergy = 38;
		
		//Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testMoveRight() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.moveRight(1);
		
		//Actual Results
		int actualX = player.getX();
		int actualY = player.getY();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedX = 11;
		int expectedY = 10;
		int expectedEnergy = 38;
		
		//Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testEat() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.eat();
		
		//Actual Results
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedEnergy = 46;
		
		//Assertions
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testMoveUpTwo() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.moveUp(2);
		
		//Actual Results
		int actualX = player.getX();
		int actualY = player.getY();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedX = 10;
		int expectedY = 8;
		int expectedEnergy = 34;
		
		//Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testMoveDownThree() {
		
		player = new Player(initXCor, initYCor, initEnergy);
		
		//Actions
		player.moveDown(3);
		
		//Actual Results
		int actualX = player.getX();
		int actualY = player.getY();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedX = 10;
		int expectedY = 13;
		int expectedEnergy = 26;
		
		//Assertions
		assertEquals(expectedX, actualX);
		assertEquals(expectedY, actualY);
		assertEquals(expectedEnergy, actualEnergy);
	}
	
	@Test
	void testTrap() {
		
		player = new Player(initXCor, initYCor, initEnergyMore);
		
		//Actions
		player.putTrap();
		
		//Actual Results
		int actualTraps = player.getTrapPut();
		int actualEnergy = player.getEnergy();
		
		//Expected Results
		int expectedTraps = 1;
		int expectedEnergy = 50;
		
		//Assertions
		assertEquals(expectedTraps, actualTraps);
		assertEquals(expectedEnergy, actualEnergy);
	}

}
