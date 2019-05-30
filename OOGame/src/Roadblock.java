
public class Roadblock {
	private Cell currentCell;
	private int health;
	private boolean active;

	public Roadblock(Grid g, Cell cell) {
		currentCell = cell;
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

	public void setCell(Cell c) {
		currentCell = c;
	}

	public Cell getCell() {
		return currentCell;
	}

}