import java.awt.event.KeyEvent;

public class Player {
	private char keypress;
	private boolean pressed;
	private int xCor, yCor, energy;
	private int trapPut = 0;
	private Trap[] traps = new Trap[3];

	public Player(int xCor, int yCor, int energy) {
		this.xCor = xCor;
		this.yCor = yCor;
		this.energy = energy;
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
			yCor -= 1;
			energy -= 2;
		} else if (presses == 2) {
			yCor -= 2;
			energy -= 6;
		} else if (presses > 2) {
			yCor -= 3;
			energy -= 14;
		}
	}

	public void moveDown(int presses) {
		if (presses == 1) {
			yCor += 1;
			energy -= 2;
		} else if (presses == 2) {
			yCor += 2;
			energy -= 6;
		} else if (presses > 2) {
			yCor += 3;
			energy -= 14;
		}
	}

	public void moveLeft(int presses) {
		if (presses == 1) {
			xCor -= 1;
			energy -= 2;
		} else if (presses == 2) {
			xCor -= 2;
			energy -= 6;
		} else if (presses > 2) {
			xCor -= 3;
			energy -= 14;
		}
	}

	public void moveRight(int presses) {
		if (presses == 1) {
			xCor += 1;
			energy -= 2;
		} else if (presses == 2) {
			xCor += 2;
			energy -= 6;
		} else if (presses > 2) {
			xCor += 3;
			energy -= 14;
		}
	}

	public void eat() {
		energy += 6;
	}
	
	public void putTrap() {
		energy -= 50;
		
		traps[trapPut] = new Trap (xCor, yCor);
		
		trapPut += 1;
	}

	public int getX() {
		return xCor;
	}

	public int getY() {
		return yCor;
	}

	public int getEnergy() {
		return energy;
	}
	
	public int getTrapPut() {
		return trapPut;
	}

	public void setKey(char key, Boolean press) {
		keypress = key;
		pressed = press;
	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			this.setKey('L', true);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			this.setKey('R', true);
		if (ke.getKeyCode() == KeyEvent.VK_UP)
			this.setKey('U', true);
		if (ke.getKeyCode() == KeyEvent.VK_DOWN)
			this.setKey('D', true);
	}

	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			this.setKey('L', false);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			this.setKey('R', false);
		if (ke.getKeyCode() == KeyEvent.VK_UP)
			this.setKey('U', false);
		if (ke.getKeyCode() == KeyEvent.VK_DOWN)
			this.setKey('D', false);
	}
}
