
/* This class encapsulates Monster position and direction
 * It also keeps a reference to the player it is tracking
 * The canView attribute can be used to limit monster visibility
 */

public class Monster extends Moveable {
	private boolean canView = true; // allows
	private Player player;
	private int countRange = 3;
	private long count = 0;

	public Monster(Grid g, Player p, int row, int col) throws Exception {
		super(g);
		player = p;
		setCell(grid.getCell(row, col));
	}

	public Cell move(int presses)
	{
		currentDirection = grid.getBestDirection(currentCell, player.getCell());
        currentCell = (grid.getCell(getCell(),getDirection(), 1));
        return currentCell;
	}

	public boolean viewable() // can be used for hiding
	{
		Cell p = player.getCell();
		Cell m = this.getCell();
		if (Math.abs(p.col - m.col) > 4 || Math.abs(p.row - m.row) > 4) {
			if ((count / countRange) % 2 == 0) {
				canView = true;
			} else {
				canView = false;
			}
		} else {
			canView = true;
		}
		count++;
		return canView;
	}
}
