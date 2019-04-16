
public class Player extends Movement{
	private boolean ready = false;
	public Player(Grid grid,int X,int Y) {
		super(grid);
		currentCell = grid.getCell(Y, X);   
		currentDirection = ' ';
	}

	@Override
	public Cell move() {
		return currentCell = grid.getCell(currentCell,currentDirection);
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
	public boolean isReady() {
		return ready;
	}
}
