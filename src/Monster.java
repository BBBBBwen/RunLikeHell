
public class Monster {
	private char keypress;
	private boolean pressed;
	private int y;
	private int x;
	private int Mspeed;

	public Monster(int initialX, int initialY, int initialMspeed) {
		x = initialX;
		y = initialY;
		this.Mspeed = initialMspeed;
	}

	public void action() {
		if (keypress == 'L' && pressed) {
			moveLeft(1);
		}
		if (keypress == 'R' && pressed) {
			moveRight(1);
		}
		if (keypress == 'U' && pressed) {
			moveUp(1);
		}
		if (keypress == 'D' && pressed) {
			moveDown(1);
		}
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

	public int hidden() {
    
	return hidden();
	}

	public void jump() {

	}

}
