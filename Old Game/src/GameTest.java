import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void test() {
		Game g = new Game();
		g.setTime(1000);
		assertEquals(1000,g.getTime());
	}

}
