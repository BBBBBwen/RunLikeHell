
public class Nougat {
	private Cell currentCell;
	private boolean notEaten = true;

	public Nougat(Grid g, Cell cell) {
		currentCell = cell;
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