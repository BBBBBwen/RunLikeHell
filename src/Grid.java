public class Grid {
	private int multiplier;
	private int roadSize;
	private int mapSize;
	private Cell road[];//////////// roads
	private Cell map[][];///////// whole map

	public Grid(int difficulty) {
		setMultiplier(difficulty);
		roadSize = (2 + multiplier) * (10 + 9 * multiplier);
		mapSize = 6 + (5 * multiplier);
		road = new Cell[roadSize];
		map = new Cell[mapSize][mapSize];
		int k = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if ((i % 5 == 0) || (j % 5 == 0 && i % 5 != 0)) {
					map[i][j] = new Cell(i, j);
					road[k++] = map[i][j];
				}
			}
		}
	}

	public void setMultiplier(int difficulty) {
			this.multiplier = difficulty;
	}

	public Cell[] getCells() {
		return road;
	}

	public int getRoad() {
		return roadSize;
	}

	public int getSize() {
		return mapSize;
	}

}