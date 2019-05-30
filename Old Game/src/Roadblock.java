
public class Roadblock {
	private int xCor, yCor, health;
	private boolean active;

	public Roadblock(int xCor, int yCor) {
		this.xCor = xCor;
		this.yCor = yCor;
		this.health = 4;
		active = true;
	}

	public int getX() {
		return xCor;
	}

	public int getY() {
		return yCor;
	}

	public int getHealth() {
		return health;
	}

	public boolean getState() {
		return active;
	}

	public void healthDec() {
		health -= 1;
	}
	
	public void deactivate() {
		active = false;
	}

}
