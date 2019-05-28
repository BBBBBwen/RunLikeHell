
public class Monster {

	private boolean hidden = false;
	private int y;
	private int x;
	private int Mspeed;
	private Grid grid;
	private int distanceMax;
	private int distanceX;
	private int distanceY;

	public Monster(int initialX, int initialY, int initialMspeed) {
		x = initialX;
		y = initialY;
		this.Mspeed = initialMspeed;
	}

	public int getMspeed() {
		return Mspeed;
	}

	public void setMspeed(int mspeed) {
		Mspeed = 1;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	boolean invalid(int col, int row) {
		int column = grid.getMapSize();
		if (col < 0 || row < 0 || col > column - 1 || row > column - 1) {
			return true;
		}
		Cell map[][] = grid.getMap();
		if (map[row][col] == null) {
			return true;
		}
		return false;
	}

	public void action() {
		distanceMax = 2 * grid.getMapSize() * grid.getMapSize();
		distanceX = x;
		distanceY = y;
		shortestDistance(x, y);
		shortestDistance(x + 1, y);
		shortestDistance(x - 1, y);
		shortestDistance(x, y + 1);
		shortestDistance(x, y - 1);
		x = distanceX;
		y = distanceY;
		grid.setMonster(new Cell(x, y));

		HandleHidden(x, y);
	}

	void shortestDistance(int col, int row) {
		Cell cellP = grid.getPlayer();
		if (!invalid(col, row)) {
			int distance = (col - cellP.getX()) * (col - cellP.getX()) + (row - cellP.getY()) * (row - cellP.getY());
			if (distance < distanceMax) {
				distanceMax = distance;
				distanceX = col;
				distanceY = row;
			}
		}
	}

	public void HandleHidden(int x, int y) {
		Cell cellP = grid.getPlayer();
		if (Math.abs(cellP.getX() - x) > 4 || Math.abs(cellP.getY() - y) > 4) {
			this.hidden();

		} else {
			this.unhid();
		}

	}

	public int getX()

	{
		return x;
	}

	public int getY()

	{
		return y;
	}

	public void hidden() {

		hidden = true;

	}

	public void unhid() {

		hidden = false;
	}

	public boolean getHidden() {

		return hidden;

	}

}
