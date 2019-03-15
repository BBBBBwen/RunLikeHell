import java.awt.*;
import javax.swing.*;

public class Paint extends JPanel {
	private final int cellWidth = 40;
	private final int cellHeight = 40;
	private final int Xalign = 100;
	private final int Yalign = 40;

	public Paint() {
	}

	private int x(int row) {
		return Xalign+row * cellWidth;
	}

	private int y(int col) {
		return Yalign+col * cellHeight;
	}

	public void paintComponent(Graphics graphic) {
		Grid grid = new Grid();
		super.paintComponent(graphic);
		Cell[] cells = grid.getCells();
		for (int i = 0; i < cells.length; i++) {
			graphic.setColor(Color.white);
			graphic.fillRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
			graphic.setColor(Color.black);
			graphic.drawRect(x(cells[i].getX()), y(cells[i].getY()), cellWidth, cellHeight);
		}
	}
}
