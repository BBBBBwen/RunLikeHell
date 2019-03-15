public class Grid {
	int road = 57;
	int mapSize = 11;
	Cell cells[] = new Cell[road];////////////roads
	Cell cells2D[][] = new Cell[mapSize][mapSize];/////////whold map

	public Grid() {
		int k = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
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

	public int setRoad(int road) {
		return this.road = road;///////////////////////determain the road that objects can go through
	}

	public int setSize(int size) {
		return this.mapSize = size;  //////////////////////determain the size of the map
	}

	public static void main(String[] args) {//////////testing purpose
		Grid grid = new Grid();
		Cell[] cell = grid.getCells();
		for (int n = 0; n < 9; n++)
			System.out.println(cell[n].getX() + " " + cell[n].getY());
	}
}