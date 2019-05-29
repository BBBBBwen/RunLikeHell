import java.awt.*;
import javax.swing.*;

public class gamePanel extends JPanel {
	private Player player;
	private Monster monster;
	private Graphics graphics;
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
    this.graphics = this.getGraphics();
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
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		Cell cells[] = grid.getAllCells();
		Cell cell;
		for (int i = 0; i < cells.length; i++) {
			cell = cells[i];
			if (cell.col % 5 == 0 && cell.row % 5 == 0)
				graphics.setColor(Color.cyan);
			else
				graphics.setColor(Color.white);
			graphics.fillRect(xCor(cell.col), yCor(cell.row), CELLWIDTH, CELLHEIGHT);
			graphics.setColor(Color.black);
			graphics.drawRect(xCor(cell.col), yCor(cell.row), CELLWIDTH, CELLHEIGHT);
		}
		cell = player.getCell();
		graphics.setColor(Color.red);
		graphics.fillOval(xCor(cell.col) + CELLWIDTH / 8, yCor(cell.row) + CELLWIDTH / 8, CELLWIDTH * 3 / 4,
				CELLHEIGHT * 3 / 4);
		graphics.setColor(Color.white);
		graphics.drawString("P", xCor(cell.col) + CELLWIDTH / 3, yCor(cell.row) + 2 * CELLWIDTH / 3);

		if (monster.viewable()) {
			cell = monster.getCell();
			graphics.setColor(Color.black);
			graphics.fillRect(xCor(cell.col), yCor(cell.row), CELLWIDTH, CELLHEIGHT);
			graphics.setColor(Color.white);
			graphics.drawString("M", xCor(cell.col) + CELLWIDTH / 3, yCor(cell.row) + 2 * CELLWIDTH / 3);
		}
	}
}
