
public class Monster {

	private boolean hidden;
	private int y;
	private int x;
	private int Mspeed;


	public Monster(int initialX, int initialY, int initialMspeed) {
		x = initialX;
		y = initialY;
		this.Mspeed = initialMspeed;
	}

	public void action() {
		
		}
	

	public void moveUp(int presses) {
		if (presses == 1) {
			y -= 1;
		}
	}

	public void moveDown(int presses) {
		if (presses == 1) {
			y += 1;

		}
	}

	public void moveLeft(int presses) {
		if (presses == 1) {
			x -= 1;

		}
	}

	public void moveRight(int presses) {
		if (presses == 1) {
			x += 1;

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
    
     hidden= true;
	
	}
    public void unhid(){
	
	
	hidden= false;
}



public boolean getHidden() {
	
	return hidden;
	
}

	
	
}
