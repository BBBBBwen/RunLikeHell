
public class BabyMonster extends Moveable {
    boolean canView = true;
	private Player player;
	public BabyMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g);
		player = p;
		setCell(grid.getCell(row,col));
	}
	public Cell move()
	{
		currentDirection = grid.getBestDirection(currentCell, player.getCell());
        currentCell = (grid.getCell(getCell(),getDirection()));
        return currentCell;
	}

}
