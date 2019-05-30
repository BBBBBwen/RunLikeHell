
public class Roadblock {
	private Cell currentCell;
	private Grid grid;
	private int health;
	private boolean active;

	public Roadblock(Grid g, int row, int col) throws Exception {
		currentCell = grid.getCell(row, col);
		this.health = 4;
		active = true;
	}

	public int getHealth() {
		return health;
	}

	public boolean getState() {
		return active;
	}

	public void healthDec() {
		health -= 1;
	}

	public void deactivate() {
		active = false;
	}

	public void setCell(Cell c) {
		currentCell = c;
	}

	public Cell getCell() {
		return currentCell;
	}

}