import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class BoardPanel extends JPanel {
	private Player player;
	private Monster monster;
	private Grid grid;
	private Game game;
	private final int cellWidth = 35;
	private final int cellHeight = 35;
	private final int Lmargin = 100;
	private final int Tmargin = 40;

	public BoardPanel(Grid grid, Player player, Monster monster) {
		this.player = player;
		this.grid = grid;
		this.monster = monster;
	}

	/* responds to various button clicked messages */
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().compareTo("up") == 0)
			player.setDirection('U');
		else if (((JButton) e.getSource()).getText().compareTo("down") == 0)
			player.setDirection('D');
		else if (((JButton) e.getSource()).getText().compareTo("left") == 0)
			player.setDirection('L');
		else if (((JButton) e.getSource()).getText().compareTo("right") == 0)
			player.setDirection('R');
		else if (((JButton) e.getSource()).getText().compareTo("start") == 0)
			player.setReady(true);
	}

	/* returns the x coordinate based on left margin and cell width */
	private int xCor(int col) {
		return Lmargin + col * cellWidth;
	}

	/* returns the y coordinate based on top margin and cell height */
	private int yCor(int row) {
		return Tmargin + row * cellHeight;
	}

	/*
	 * Redraws the board and the pieces Called initially and in response to
	 * repaint()
	 */
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Cell cells[] = grid.getAllCells();
		Cell cell;
		for (int i = 0; i < cells.length; i++) {
			cell = cells[i];
			if (cell.col % 5 == 0 && cell.row % 5 == 0)
				graphics.setColor(Color.cyan);
			else
				graphics.setColor(Color.white);
			graphics.fillRect(xCor(cell.col), yCor(cell.row), cellWidth, cellHeight);
			graphics.setColor(Color.black);
			graphics.drawRect(xCor(cell.col), yCor(cell.row), cellWidth, cellHeight);
		}
		cell = player.getCell();
		graphics.setColor(Color.red);
		graphics.fillOval(xCor(cell.col) + cellWidth / 8, yCor(cell.row) + cellHeight / 8, cellWidth * 3 / 4,
				cellHeight * 3 / 4);
		graphics.setColor(Color.white);
		graphics.drawString("P", xCor(cell.col) + cellWidth / 3, yCor(cell.row) + 2 * cellWidth / 3);

		if (monster.viewable()) {
			cell = monster.getCell();
			graphics.setColor(Color.black);
			graphics.fillRect(xCor(cell.col), yCor(cell.row), cellWidth, cellHeight);
			graphics.setColor(Color.white);
			graphics.drawString("M", xCor(cell.col) + cellWidth / 3, yCor(cell.row) + 2 * cellWidth / 3);
		}
	}
}
