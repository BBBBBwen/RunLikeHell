public class Grid {
	Cell cells[] = new Cell[57];
	Cell cells2D[][] = new Cell[11][11];

	public Grid() {
		int k = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if ((i % 5 == 0) || (j % 5 == 0 && i % 5 != 0)) {
					cells2D[i][j] = new Cell(i, j);
					cells[k++] = cells2D[i][j];
				}
			}
		}
	}

	public Cell[] getCells() {
		return cells;
	}

	public static void main(String[] args) {
		Grid grid = new Grid();
		Cell[] cell = grid.getCells();
		for (int n = 0; n < 9; n++)
			System.out.println(cell[n].getX() + " " + cell[n].getY());
	}
}