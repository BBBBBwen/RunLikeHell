package run;

public class Cell {
	private int row;
	private int col;
	private int status;

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getX() {
		return row;
	}

	public int getY() {
		return col;
	}
	

}