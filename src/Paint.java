import java.awt.*;
import javax.swing.*;

public class Paint extends JPanel {
	private int cellWidth = 40;
	private int cellHeight = 40;
	private final int Xalign = 100;
	private final int Yalign = 40;
	Player player;
	
	public Paint() {
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
		Grid grid = new Grid();
		super.paintComponent(graphic);
		Cell[] cells = grid.getCells();
		for (int i = 0; i < cells.length; i++) {
			graphic.setColor(Color.white);
			graphic.fillRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
			graphic.setColor(Color.black);
			graphic.drawRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
		}
		Cell playerCell = new Cell(0,0);
		graphic.setColor(Color.black);
		graphic.fillRect(x(playerCell.getX()), y(playerCell.getY()), cellWidth, cellHeight);
		graphic.setColor(Color.black);
		graphic.drawRect(x(playerCell.getX()), y(playerCell.getY()), cellWidth, cellHeight);
	
	}
}
