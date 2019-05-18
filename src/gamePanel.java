
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class gamePanel extends JPanel {
	private int cellWidth = 35;
	private int cellHeight = 35;
	private final int Xalign = 100;
	private final int Yalign = 40;
	private Player player;
	private Monster monster;
	private Grid grid;

	public gamePanel(Player player, Monster monster, Grid grid) {
		this.player = player;
		this.monster = monster;
		this.grid = grid;
		this.requestFocus();
	}

	public void setCellWidth(int cellWidth) {
		this.cellWidth = cellWidth;
	}

	public void setCellHeight(int cellHeight) {
		this.cellHeight = cellHeight;
	}

	public int x(int row) {
		return Xalign + row * cellWidth;////////////// x location of a cell
	}

	public int y(int col) {
		return Yalign + col * cellHeight;////////////////// y location of a cell
	}

	public void paintComponent(Graphics graphic) {////////// draw whole things, not complete
		super.paintComponent(graphic);
		Cell[] cells = grid.getCells();
		for (int i = 0; i < cells.length; i++) {
			graphic.setColor(Color.white);
			graphic.fillRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
			graphic.setColor(Color.black);
			graphic.drawRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
		}
		Cell playerCell = new Cell(player.getX(), player.getY());
		graphic.setColor(Color.red);
		graphic.fillRect(x(playerCell.getX()), y(playerCell.getY()), cellWidth, cellHeight);
		graphic.setColor(Color.black);
		graphic.drawRect(x(playerCell.getX()), y(playerCell.getY()), cellWidth, cellHeight);
		Cell monsterCell = new Cell(monster.getX(), monster.getY());
		if (!monster.getHidden()){
		graphic.setColor(Color.blue);
		graphic.fillRect(x(monster.getX()), y(monster.getY()), cellWidth, cellHeight);
		graphic.setColor(Color.black);
		graphic.drawRect(x(monster.getX()), y(monster.getY()), cellWidth, cellHeight);
		}
	}
}
