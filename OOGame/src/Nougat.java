
public class Nougat {
	private Cell currentCell;
	private Grid grid;
	private boolean notEaten = true;

	public Nougat(Grid g, int row, int col) throws Exception {
		currentCell = grid.getCell(row, col);
	}

	public boolean getState() {
		return notEaten;
	}

	public void eaten() {
		notEaten = false;
	}

	public void setCell(Cell c) {
		currentCell = c;
	}

	public Cell getCell() {
		return currentCell;
	}

}