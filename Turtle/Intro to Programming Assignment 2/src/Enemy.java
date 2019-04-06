import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Enemy {
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
	private BufferedImage imageCurrent;
	private int x;
	private int y;
	private GameManager gam;
	private int targ;

	public Enemy(GameManager game, int width, int height) {
		x = width;
		y = height;
		gam = game;
		try {
			this.imageRunning = ImageIO.read(new File(
					"C:\\Users\\rayn1\\Desktop\\itp_workspace\\Intro to Programming Assignment 2\\src\\enemy-alive.png"));
			this.imageOver = ImageIO.read(new File(
					"C:\\Users\\rayn1\\Desktop\\itp_workspace\\Intro to Programming Assignment 2\\src\\enemy-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.imageCurrent = this.imageRunning;
	}

	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}

	public void performAction() {
		this.setTarget();
		if (x < gam.getGoal(targ).getX()) {
			x += 2;
		}
		if (x > gam.getGoal(targ).getX()) {
			x -= 2;
		}
		if (y < gam.getGoal(targ).getY()) {
			y += 2;
		}
		if (y > gam.getGoal(targ).getY()) {
			y -= 2;
		}
	}

	public void setTarget() {
		double minDis = -1;
		int c = 0;
		while (minDis == -1 && c < gam.getMaxGoal()) {
			if (gam.getGoal(c).getAlive()) {
				minDis = Math.pow(x - gam.getGoal(c).getX(), 2) + Math.pow(y - gam.getGoal(c).getY(), 2);
			}
			targ = c;
			c++;
		}
		while (c < gam.getMaxGoal()) {
			if (gam.getGoal(c).getAlive()) {
				if ((Math.pow(x - gam.getGoal(c).getX(), 2) + Math.pow(y - gam.getGoal(c).getY(), 2)) < minDis) {
					minDis = Math.pow(x - gam.getGoal(c).getX(), 2) + Math.pow(y - gam.getGoal(c).getY(), 2);
					targ = c;
				}
			}
			c++;
		}
	}

	public void die() {
		this.imageCurrent = this.imageOver;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
