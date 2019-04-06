import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
	private BufferedImage imageCurrent;
	private char keypress;
	private boolean pressed;
	private int x;
	private int y;

	public Player(int width, int height) {
		x = width;
		y = height;
		try {
			this.imageRunning = ImageIO.read(new File(
					"C:\\Users\\rayn1\\Desktop\\itp_workspace\\Intro to Programming Assignment 2\\src\\player-alive.png"));
			this.imageOver = ImageIO.read(new File(
					"C:\\Users\\rayn1\\Desktop\\itp_workspace\\Intro to Programming Assignment 2\\src\\player-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageCurrent = this.imageRunning;
	}

	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}

	public void performAction() {
		if (keypress == 'L' && pressed) {
			x -= 10;
		}
		if (keypress == 'R' && pressed) {
			x += 10;
		}
		if (keypress == 'U' && pressed) {
			y -= 10;
		}
		if (keypress == 'D' && pressed) {
			y += 10;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void die() {
		this.imageCurrent = this.imageOver;
	}

	public void setKey(char key, Boolean press) {
		keypress = key;
		pressed = press;
	}

}
