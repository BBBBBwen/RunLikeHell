package 游戏练习;

import java.awt.Graphics2D;

public class Monster {

	private int y;
	private int x;
	private int Mspeed;
	private String image = "/Users/mac/Desktop/23091897.jpg";
	


	public Monster(int initialX, int initialY, int initialMspeed) {
		x = initialX;
		y = initialY;
		this.Mspeed = initialMspeed;
	}

	public void draw(Graphics2D  g2d) {
		
  
		
		
		
	}

	public void Move()// Monster movement

	{
		if (x + Mspeed <= 2)
			;
		x = x + Mspeed;
	}

	public boolean notMove()

	{
		if (Mspeed == 1)
			return true;
		else
			return false;
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

	}

	public void babymonster() {

	}

}
