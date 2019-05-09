
public class Grid {
	private int multiplier;
	private int roadSize;
	private int mapSize;// column
	private Cell player;
	private Cell monster;
	private Cell road[];//////////// roads
	private Cell map[][];///////// whole map

	public Cell getPlayer() {
		return player;
	}

	public void setPlayer(Cell player) {
		this.player = player;
	}

	public Cell getMonster() {
		return monster;
	}

	public void setMonster(Cell monster) {
		this.monster = monster;
	}

	public int getRoadSize() {
		return roadSize;
	}

	public void setRoadSize(int roadSize) {
		this.roadSize = roadSize;
	}

	public int getMapSize() {
		return mapSize;
	}

	public void setMapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	public Cell[][] getMap() {
		return map;
	}

	public void setMap(Cell[][] map) {
		this.map = map;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setRoad(Cell[] road) {
		this.road = road;
	}

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
				} else {
					map[i][j] = null;
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