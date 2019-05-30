
public class babyMonster extends Monster{
	private boolean hidden = false;
	private int y;
	private int x;
	private int Bmspeed;
	private Grid grid;
	private int distanceMax;
	private int distanceX;
	private int distanceY;
	private long actionCount = 1;
	public babyMonster(int initialX, int initialY, int initialMspeed) {
		super(initialX, initialY, initialMspeed);
		// TODO Auto-generated constructor stub
		x= initialX;
		y= initialY;
		this.Bmspeed = initialMspeed;
	}

	public int getBmspeed() {
		return Bmspeed;
	}
	
	public void setBmspeed(int bmspeed) {
		Bmspeed = bmspeed;
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


	public int getX()

	{
		return x;
	}

	public int getY()

	{
		return y;
	}


}
