
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
	private char keypress;
	private boolean ready = false;
	private int xCor, yCor, energy;
	private int trapPut = 0;
	private int roadblockPut = 0;
	private Trap[] traps = new Trap[99];
	private Roadblock[] roadblocks = new Roadblock[3];
	private int presses = 0;

	public Player(int xCor, int yCor, int energy) {
		this.xCor = xCor;
		this.yCor = yCor;
		this.energy = energy;
	}

	public char getKeypress() {
		return keypress;
	}
	
	public int getPresses() {
		return presses;
	}

	public void setKeypress(char keypress) {
		this.keypress = keypress;
	}

	public int getxCor() {
		return xCor;
	}

	public void setxCor(int xCor) {
		this.xCor = xCor;
	}

	public int getyCor() {
		return yCor;
	}

	public void setyCor(int yCor) {
		this.yCor = yCor;
	}

	public Trap[] getTraps() {
		return traps;
	}

	public void setTraps(Trap[] traps) {
		this.traps = traps;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void setTrapPut(int trapPut) {
		this.trapPut = trapPut;
	}

	private Grid grid;

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public void setReady() {
		this.ready = true;
	}

	public boolean isReady() {
		return ready;
	}

	boolean invalid(int col, int row) {
		int column = grid.getMapSize();
		if (col < 0 || row < 0 || col > column - 1 || row > column - 1) {
			return true;
		}
		Cell map[][] = grid.getMap();
		if (map[row][col] == null) {
			return true;
		}
		return false;
	}

	public void action() {
		if (keypress == 'L') {
			xCor -= 1;
			if (invalid(xCor, yCor)) {
				xCor += 1;
			}
		} else if (keypress == 'R') {
			xCor += 1;
			if (invalid(xCor, yCor)) {
				xCor -= 1;
			}
		} else if (keypress == 'U') {
			yCor -= 1;
			if (invalid(xCor, yCor)) {
				yCor += 1;
			}
		} else if (keypress == 'D') {
			yCor += 1;
			if (invalid(xCor, yCor)) {
				yCor -= 1;
			}
		}
		grid.setPlayer(new Cell(xCor, yCor));
		keypress = ' ';
		this.presses = 0;
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

		traps[trapPut] = new Trap(xCor, yCor);

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
			this.presses += 1;
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.setKey('R');
			this.presses += 1;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			this.setKey('U');
			this.presses += 1;
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			this.setKey('D');
			this.presses += 1;
		}
	}

	public void keyReleased(KeyEvent ke) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
