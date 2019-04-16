import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener{
	private final int cellWidth = 30;
	private final int cellHeight = 30;
	private Grid grid;
	private Player player;
	private Monster monster;
	public Board(Grid grid,Player player,Monster monster) {
		this.grid = grid;
		this.player = player;
		this.monster = monster;
	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_LEFT)
			player.setKey('L');
		else if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setKey('R');
		else if (ke.getKeyCode() == KeyEvent.VK_UP)
			player.setKey('U');
		else if (ke.getKeyCode() == KeyEvent.VK_DOWN)
			player.setKey('D');
	}
	
	private int x(int row) {
		return row * cellWidth;
	}

	private int y(int col) {
		return col * cellHeight;
	}

	public void paintComponent(Graphics graphic) {
		super.paintComponents(graphic);
		Cell[] cells = grid.getPassable();
		Cell cell;
		for (int i = 0; i < cells.length; i++) {
			graphic.setColor(Color.white);
			graphic.fillRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
			graphic.setColor(Color.black);
			graphic.drawRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
		}
		cell = player.getCell();
		graphic.setColor(Color.red);
		graphic.fillOval(x(cell.getX())+cellWidth/8, y(cell.getY())+cellWidth/8, cellWidth*3/4, cellHeight*3/4);
        
        if (monster.viewable())
        {
           cell = monster.getCell();
           graphic.setColor(Color.black);
           graphic.fillRect(x(cell.getX()), y(cell.getY()), cellWidth, cellHeight);
        }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
