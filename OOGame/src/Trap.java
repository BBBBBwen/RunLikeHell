
public class Trap {
	private Cell currentCell;
	private int timeRemain;
	private boolean active;

	public Trap(Grid g, Cell cell) {
		currentCell = cell;
		active = true;
		timeRemain = 10;
	}

	public int getTime() {
		return timeRemain;
	}

	public boolean getState() {
		return active;
	}

	public void decTime() {
		timeRemain -= 1;
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
