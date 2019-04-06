import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class Goal {
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
	private BufferedImage imageCurrent;
	private int x;
	private int y;
	private int width;
	private boolean alive;
	private int switchCount;
	private boolean randx;
	private boolean randy;

	public Goal(int width, int height) {
		switchCount = 0;
		alive = true;
		x = width;
		y = height;
		try {
			this.imageRunning = ImageIO.read(new File(
					"C:\\Users\\rayn1\\Desktop\\itp_workspace\\Intro to Programming Assignment 2\\src\\goal-alive.png"));
			this.imageOver = ImageIO.read(new File(
					"C:\\Users\\rayn1\\Desktop\\itp_workspace\\Intro to Programming Assignment 2\\src\\goal-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageCurrent = this.imageRunning;
	}

	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}

	public void performAction() {
		this.counter();
		if (switchCount == 100) {
			Random randValue = new Random();
			randx = randValue.nextBoolean();
			randy = randValue.nextBoolean();
		}
		if (alive) {
			if (randx) {
				x += 1;
			} else {
				x -= 1;
			}
			if (randy) {
				y += 1;
			} else {
				y -= 1;
			}
		}
	}

	public void counter() {
		switchCount++;
		if (switchCount > 100) {
			switchCount = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public void die() {
		this.imageCurrent = this.imageOver;
		alive = false;
	}

	public boolean getAlive() {
		return alive;
	}

}
