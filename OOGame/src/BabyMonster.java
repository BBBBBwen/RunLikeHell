
public class BabyMonster extends Moveable {
    boolean canView = true;
	private Player player;
	public BabyMonster(Grid g, Player p, int row, int col) throws Exception {
		super(g);
		player = p;
		setCell(grid.getCell(row,col));
	}
	public Cell move(int presses)
	{
		currentDirection = grid.getBestDirection(currentCell, player.getCell());
        currentCell = (grid.getCell(getCell(),getDirection(), 1));
        return currentCell;
	}

}
