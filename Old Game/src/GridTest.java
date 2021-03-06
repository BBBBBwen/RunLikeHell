import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void testEasy() {
		Grid grid = new Grid(0);
		assertEquals(grid.getRoad(), 20);
		assertEquals(grid.getSize(), 6);
	}
	
	@Test
	void testNormal() {
		Grid grid = new Grid(1);
		assertEquals(grid.getRoad(), 57);
		assertEquals(grid.getSize(), 11);
	}
	
	@Test
	void testHard() {
		Grid grid = new Grid(2);
		assertEquals(grid.getRoad(), 112);
		assertEquals(grid.getSize(), 16);
	}
}
