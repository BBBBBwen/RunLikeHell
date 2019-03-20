
public class Player {
	private char keypress;
	private boolean pressed;
	private int x, y, energy;

	public Player(int width, int height, int ene) {
		x = width;
		y = height;
		energy = ene;
	}
	
	public void action() {
		if (keypress == 'L' && pressed) {
			x -= 1;    // to be changed
		}
		if (keypress == 'R' && pressed) {
			x += 1;    // to be changed
		}
		if (keypress == 'U' && pressed) {
			y -= 1;    // to be changed
		}
		if (keypress == 'D' && pressed) {
			y += 1;    // to be changed
		}
		if (keypress == 'S' && pressed) {
			useSkill();    // to be improved
		}
	}
	
	public void useSkill() {
		// placeholder
	}
	
	public void die() {
		// placeholder
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setKey(char key, Boolean press) {
		keypress = key;
		pressed = press;
	}
}
