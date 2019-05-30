/* This class represents the individual cell in the grid.
 */

public class Cell {
	protected int row;
	protected int col;

	// Nougat identifier
	boolean gotGold = false;

	public Cell(int i, int j) {
		row = i;
		col = j;
	}
}
