
public class Monster extends Movement {
	private boolean viewable = true;
	private Player player;

	public Monster(Grid grid, Player player, int X, int Y) {
		super(grid);
		this.player = player;
		this.setCell(grid.getCell(Y, X));
	}

	@Override
	public Cell move() {
		currentDirection = grid.chasingStrategy(currentCell, player.getCell());
		return currentCell = (grid.getCell(getCell(), getKey()));
	}

	public void setViewable(boolean viewable) {
		this.viewable = viewable;
	}

	public boolean viewable() {
		return viewable;
	}
}
