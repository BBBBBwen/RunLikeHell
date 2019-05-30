import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridTest {
	
	@Test
	void testGetCell() throws Exception {
		Grid grid = new Grid(1);
		Cell cell = new Cell(5,5);
		assertTrue(grid.getCell(0,2).col == 2);
		assertTrue(grid.getCell(0,2).row == 0);
		assertTrue(grid.getCell(cell,'R', 1).col == 6);
		assertTrue(grid.getCell(cell,'L', 1).col == 4);
		assertTrue(grid.getCell(cell,'U', 1).row == 4);
		assertTrue(grid.getCell(cell,'D', 1).row == 6);
	}

	void testStrategy() throws Exception {
		Grid grid = new Grid(1);
		Cell fromCell = new Cell(5,5);
		Cell toCell = new Cell(6,5);
		assertTrue(grid.getBestDirection(fromCell, toCell) == 'D');
	}
}
