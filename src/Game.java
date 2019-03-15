import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {
	Grid grid;

	public Game() {
		setTitle("Run Like Hell");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		getContentPane().add(new Paint());
		panel.setLayout(new GridLayout(10, 10, 10, 10));
		JButton start = new JButton("Start");
		JButton pause = new JButton("Pause");
		JButton login = new JButton("LogIn");
		JButton register = new JButton("Register");
		JLabel time = new JLabel("Time Unit:");
		panel.add(start);
		panel.add(pause);
		panel.add(login);
		panel.add(register);
		panel.add(time);
	}

	public static void main(String args[]) throws Exception {
		Game frame = new Game();
		frame.setVisible(true);
	}
}
