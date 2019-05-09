
public class Trap {
	private int xCor, yCor, timeRemain;
	private boolean active;
	
	public Trap(int xCor, int yCor) {
		this.xCor = xCor;
		this.yCor = yCor;
		active = true;
		timeRemain = 10;
	}
	
	public int getX() {
		return xCor;
	}

	public int getY() {
		return yCor;
	}
	
	public int getTime() {
		return timeRemain;
	}
	
	public boolean getState() {
		return active;
	}
	
	public void decTime() {
		timeRemain -= 1;
	}
	
	public void deactivate() {
		active = false;
	}
}