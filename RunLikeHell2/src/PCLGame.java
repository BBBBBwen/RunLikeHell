import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PCLGame extends JFrame {
	final static int timeAllowed = 100;
	Board board;
	Player player;
	Monster monster;
	Grid grid;
	JLabel time;

	public static void main(String[] args) {
		PCLGame game = new PCLGame();
		game.setVisible(true);
		for (int time = 0; time < timeAllowed; time++)
			game.play(time);
	}

	public PCLGame() {
		grid = new Grid(0);
		player = new Player(grid, 0, 0);
		monster = new Monster(grid, player, 2, 2);
		board = new Board(grid, player, monster);

		setTitle("Run Like Hell");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 10, 10, 10));
		JButton start = new JButton("Start");
		JButton pause = new JButton("Pause");
		JButton login = new JButton("LogIn");
		JButton register = new JButton("Register");
		time = new JLabel("Time Unit: " + timeAllowed);
		panel.add(start);
		panel.add(pause);
		panel.add(login);
		panel.add(register);
		panel.add(time);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.setReady(true);
			}
		});
		this.add(board, BorderLayout.CENTER);
		this.add(panel, BorderLayout.EAST);
	}

	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void play(int time) {
		String message;
		player.move();
		monster.move();
		this.time.setText("Time Remaining : " + (timeAllowed - time));
		delay(1000);
		board.repaint();
		message = (time < timeAllowed) ? "player win" : "player lost";
		this.time.setText(message);
	}
}
