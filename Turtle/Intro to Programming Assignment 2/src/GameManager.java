import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

public class GameManager extends JFrame implements KeyListener {
	private int canvasWidth;
	private int canvasHeight;
	private int borderLeft;
	private int borderTop;
	private BufferedImage canvas;
	private Stage stage;
	private Enemy[] enemies;
	private Player player;
	private Goal[] goal;
	private Graphics gameGraphics;
	private Graphics canvasGraphics;
	private int numEnemies;
	private int numGoal;
	private boolean continueGame;
	static int enemyNum;
	static int goalNum;
	private int playerPoint;
	private int enemyPoint;

	public static void main(String[] args) {
		// During development, you can adjust the values provided in the brackets below
		// as needed. However, your code must work with different/valid combinations
		// of values.
		GameManager managerObj = new GameManager(1920, 1280, enemyNum, goalNum);
	}

	public GameManager(int preferredWidth, int preferredHeight, int enemyNum, int goalNum) {
		playerPoint = 0;
		enemyPoint = 0;
		int z = 0;
		enemyNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter enemy number"));
		goalNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter goal number"));
		this.borderLeft = getInsets().left;
		this.borderTop = getInsets().top;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if (screenSize.width < preferredWidth)
			this.canvasWidth = screenSize.width - getInsets().left - getInsets().right;
		else
			this.canvasWidth = preferredWidth - getInsets().left - getInsets().right;
		if (screenSize.height < preferredHeight)
			this.canvasHeight = screenSize.height - getInsets().top - getInsets().bottom;
		else
			this.canvasHeight = preferredHeight - getInsets().top - getInsets().bottom;
		setSize(this.canvasWidth, this.canvasHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(this);
		Random rng = new Random(2);
		this.canvas = new BufferedImage(this.canvasWidth, this.canvasHeight, BufferedImage.TYPE_INT_RGB);
		// Create a Stage object to hold the background images
		this.stage = new Stage();
		// Create a Goal object with its initial x and y coordinates
		numGoal = goalNum;
		goal = new Goal[numGoal];
		while (z < numGoal) {
			this.goal[z] = new Goal(Math.abs(rng.nextInt()) % this.canvasWidth,
					Math.abs(rng.nextInt()) % this.canvasHeight);
			z++;
		}
		// Create a Player object with its initial x and y coordinates
		this.player = new Player(this.canvasWidth - (Math.abs(rng.nextInt()) % (this.canvasWidth / 2)),
				(Math.abs(rng.nextInt()) % this.canvasHeight));

		// Create the Enemy objects, each with a reference to this (GameManager) object
		// and their initial x and y coordinates.
		this.numEnemies = enemyNum;
		this.enemies = new Enemy[this.numEnemies];
		for (int i = 0; i < this.numEnemies; i++) {
			this.enemies[i] = new Enemy(this, Math.abs(rng.nextInt()) % (this.canvasWidth/4),
					Math.abs(rng.nextInt()) % this.canvasHeight);
		}
		this.gameGraphics = getGraphics();
		this.canvasGraphics = this.canvas.getGraphics();
		this.continueGame = true;
		for (int i = 0; i < this.numEnemies; i++) {
			this.enemies[i].setTarget();
		}
		while (this.continueGame) {
			updateCanvas();
		}
		this.stage.setGameOverBackground();
		if (playerPoint > enemyPoint) {
			JOptionPane.showMessageDialog(null, "Gameover, You Won! \nYou: " + playerPoint + "\nEnemy: " + enemyPoint);
		} else if (playerPoint == enemyPoint) {
			JOptionPane.showMessageDialog(null, "Gameover, Tie! \nYou: " + playerPoint + "\nEnemy: " + enemyPoint);
		} else if (playerPoint < enemyPoint) {
			JOptionPane.showMessageDialog(null, "Gameover, You Lost! \nYou: " + playerPoint + "\nEnemy: " + enemyPoint);
		}
	}

	public void updateCanvas() {
		long start = System.nanoTime();
		// If the player is alive, this should move the player in the direction of the
		// key that has been pressed
		// Note: See keyPressed and keyReleased methods in the GameManager class.
		this.player.performAction();
		for (int d = 0; d < this.numGoal; d++) {
			this.goal[d].performAction();
		}
		// If the enemy is alive, the enemy must move towards the goal. The goal object
		// is obtained

		// via the GameManager object that is given at the time of creating an Enemy
		// object.
		// Note: The amount that the enemy moves by must be much smaller than that of
		// the player above
		// or else the game becomes too hard to play.
		for (int i = 0; i < this.numEnemies; i++) {
			this.enemies[i].performAction();
		}
		for (int j = 0; j < this.numGoal; j++) {
			if (this.goal[j].getAlive()
					&& (Math.abs(
							this.goal[j].getX() - this.player.getX()) < (this.goal[j].getCurrentImage().getWidth() / 2))
					&& (Math.abs(this.goal[j].getY() - this.player.getY()) < (this.goal[j].getCurrentImage().getWidth()
							/ 2))) {
				// Sets the image of the enemy to the "dead" image and sets its status to
				// indicate dead
				this.goal[j].die();
				playerPoint += 1;
				// Sets the background of the stage to the finished game background.
			}
		}
		// If an enemy is close to the goal, the player and goal die
		for (int z = 0; z < this.numGoal; z++) {
			int j = 0;
			while (j < this.numEnemies) {
				if (this.goal[z].getAlive()
						&& (Math.abs(this.goal[z].getX()
								- this.enemies[j].getX()) < (this.goal[z].getCurrentImage().getWidth() / 2))
						&& (Math.abs(this.goal[z].getY()
								- this.enemies[j].getY()) < (this.goal[z].getCurrentImage().getWidth() / 2))) {
					this.goal[z].die();
					enemyPoint += 1;
				}
				j++;
			}
		}
		boolean gameOver = true;
		for (int z = 0; z < this.numGoal; z++) {
			if (this.goal[z].getAlive()) {
				gameOver = false;
			}
		}

		if (gameOver) {
			this.continueGame = false;
		}

		try {
			// Draw stage
			this.canvasGraphics.drawImage(stage.getCurrentImage(), 0, 0, null);
			// Draw player
			this.canvasGraphics.drawImage(player.getCurrentImage(),
					this.player.getX() - (this.player.getCurrentImage().getWidth() / 2),
					this.player.getY() - (this.player.getCurrentImage().getHeight() / 2), null);
			// Draw enemies
			for (int i = 0; i < this.numEnemies; i++) {
				this.canvasGraphics.drawImage(this.enemies[i].getCurrentImage(),
						this.enemies[i].getX() - (this.enemies[i].getCurrentImage().getWidth() / 2),
						this.enemies[i].getY() - (this.enemies[i].getCurrentImage().getHeight() / 2), null);
			}
			// Draw goal
			for (int z = 0; z < this.numGoal; z++) {
				this.canvasGraphics.drawImage(this.goal[z].getCurrentImage(),
						this.goal[z].getX() - (this.goal[z].getCurrentImage().getWidth() / 2),
						this.goal[z].getY() - (this.goal[z].getCurrentImage().getHeight() / 2), null);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		// Draw everything.
		this.gameGraphics.drawImage(this.canvas, this.borderLeft, this.borderTop, this);
		long end = System.nanoTime();
		this.gameGraphics.drawString("FPS: " + String.format("%2d", (int) (1000000000.0 / (end - start))),
				this.borderLeft + 50, this.borderTop + 50);
	}

	public Goal getGoal(int goalcount) {
		return this.goal[goalcount];
	}

	public int getMaxGoal() {
		return numGoal;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void keyPressed(KeyEvent ke) {
		// Below, the setKey method is used to tell the Player object which key is
		// currently pressed.
		// The Player object must keep track of the pressed key and use it for
		// determining the direction
		// to move.
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			this.player.setKey('L', true);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			this.player.setKey('R', true);
		if (ke.getKeyCode() == KeyEvent.VK_UP)
			this.player.setKey('U', true);
		if (ke.getKeyCode() == KeyEvent.VK_DOWN)
			this.player.setKey('D', true);
		if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)

			this.continueGame = false;
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// Below, the setKey method is used to tell the Player object which key is
		// currently released.
		// The Player object must keep track of the pressed key and use it for
		// determining the direction
		// to move.
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			this.player.setKey('L', false);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			this.player.setKey('R', false);
		if (ke.getKeyCode() == KeyEvent.VK_UP)
			this.player.setKey('U', false);
		if (ke.getKeyCode() == KeyEvent.VK_DOWN)
			this.player.setKey('D', false);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
	}

}
