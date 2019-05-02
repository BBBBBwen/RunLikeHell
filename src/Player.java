import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener{
	private char keypress;
	private boolean pressed;
	private boolean ready = false;
	private int xCor, yCor, energy;
	private int trapPut = 0;
	private Trap[] traps = new Trap[3];

	public Player(int xCor, int yCor, int energy) {
		this.xCor = xCor;
		this.yCor = yCor;
		this.energy = energy;
	}

	public void setReady() {
		this.ready = true;
	}
	
	public boolean isReady() {
		return ready;
	}
	
	public void action() {
		if (keypress == 'L') {
			xCor -= 1;
		}else
		if (keypress == 'R') {
			xCor += 1;
		}else
		if (keypress == 'U') {
			yCor -= 1;
		}else
		if (keypress == 'D') {
			yCor += 1;
		}
		keypress= ' ';
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

	public void setKey(char key) {
		keypress = key;
	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			this.setKey('L');
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.setKey('R');
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			this.setKey('U');
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			this.setKey('D');
		}
	}

	public void keyReleased(KeyEvent ke) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
