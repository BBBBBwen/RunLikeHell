import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void test() {
		Grid g = new Grid();
		g.setRoad(100);
		g.setSize(20);
		assertEquals(g.getRoad(), 100);
		assertEquals(g.getSize(),20);
	}

}
