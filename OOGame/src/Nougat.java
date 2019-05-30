
public class Nougat {
	private int xCor, yCor;
	private boolean notEaten = true;
	
	public Nougat (int xCor, int yCor) {
		this.xCor = xCor;
		this.yCor = yCor;
	}
	
	public int getX() {
		return xCor;
	}
	
	public int getY() {
		return yCor;
	}
	
	public boolean getState() {
		return notEaten;
	}
	
	public void eaten() {
		notEaten = false;
	}

}