import javax.swing.*;

import java.awt.*;

/* This class is the main System level class which creates all the objects
 * representing the game logic (model) and the panel for user interaction.
 * It also implements the main game loop
 */

public class Game extends JFrame {

	private final int timeAllowed = 100;
	private int difficulty = 1;
	private JButton start = new JButton("Start"); /////////////////// all button starts here
	private JButton pause = new JButton("Pause");
	private JButton login = new JButton("LogIn");
	private JButton register = new JButton("Register");
	private JButton rank = new JButton("Rank");
	private private JLabel timeLabel = new JLabel("Time Remaining : " + timeAllowed);

	private Grid grid;
	private Player player;
	private Monster monster;
	private BoardPanel boardPanel;

	/*
	 * This constructor creates the main model objects and the panel used for UI. It
	 * throws an exception if an attempt is made to place the player or the monster
	 * in an invalid location.
	 */
	public Game() throws Exception {
		grid = new Grid();
		player = new Player(grid, 0, 0);
		monster = new Monster(grid, player, 5, 5);
		boardPanel = new BoardPanel(grid, player, monster);

		// Create a separate panel and add all the buttons
		JPanel controlPane = new JPanel();
		controlPane.add(start);
		controlPane.add(pause);
		controlPane.add(login);
		controlPane.add(register);
		controlPane.add(rank);
		start.addKeyListener(player);

		// add Action listeners to all button events
		start.addActionListener(new MyActionListener());
		pause.addActionListener(new MyActionListener());
		login.addActionListener(new MyActionListener());
		register.addActionListener(newMyActionListener());
		rank.addActionListener(new MyActionListener());

		// add panels to frame
		this.add(boardPanel, BorderLayout.CENTER);
		this.add(controlPane, BorderLayout.EAST);
	}

	// method to delay by specified time in ms
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method waits until play is ready (until start button is pressed) after
	 * which it updates the moves in turn until time runs out (player won) or player
	 * is eaten up (player lost).
	 */
	public void setDifficulty() {
		String diff = JOptionPane.showInputDialog(null, "set Diificuty(easy,normal,hard)");
		if (diff.equals("easy"))
			this.difficulty = 0;
		else if (diff.equals("normal"))
			this.difficulty = 1;
		else if (diff.equals("hard"))
			this.difficulty = 2;
	}

	public String play() {
		int time = 0;
		boolean check = true;
		String message;
		player.setDirection(' '); // set to no direction
		while (!player.isReady())
			delay(100);
		do {
			Cell newPlayerCell = player.move();
			Cell newMonsterCell = monster.move();
			if (newPlayerCell != monster.getCell() && newMonsterCell != player.getCell()) {
				player.setDirection(' '); // reset to no direction
				// update time and repaint
				time++;
				timeLabel.setText("Time Remaining : " + (timeAllowed - time));
				delay(1000);
				boardPanel.repaint();
			}
			check = false;
		} while (time < timeAllowed && check);
		message = time < timeAllowed ? "Player Lost" : "Player Won"; // players has been eaten up

		timeLabel.setText(message);
		return message;
	}

	public static void main(String args[]) throws Exception {
		Game game = new Game();
		game.setTitle("RunLikeHell");
		game.setSize(700, 700);
		game.setLocationRelativeTo(null); // center the frame
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		game.play();
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String label = e.getActionCommand();
			if (label.equals("LogIn")) {
				new Login();
			}
			if (label.equals("Register")) {
				new Register();
			}
			if (label.equals("Rank")) {
				JOptionPane.showMessageDialog(null, userData.getList());
			}
			if (label.equals("Start")) {
				player.setReady();
			}
		}
	}

	class Login extends JFrame {
		public Login() {
			setTitle("Login");
			JLabel label1 = new JLabel("UserName");
			label1.setBounds(10, 10, 200, 18);
			JLabel label2 = new JLabel("Password");
			label2.setBounds(10, 50, 200, 18);
			JTextField textField1 = new JTextField();
			textField1.setBounds(90, 10, 150, 18);
			JTextField textField2 = new JTextField();
			textField2.setBounds(90, 50, 150, 18);
			JButton button1 = new JButton("Confirm");
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userData = new UserData();
					boolean flag = userData.login(textField1.getText(), textField2.getText());
					if (flag) {
						JOptionPane.showMessageDialog(button1, "Sucsuss");
						dispose();
					} else {
						JOptionPane.showMessageDialog(button1, "fail");
					}
				}
			});
			button1.setBounds(40, 80, 100, 18);
			JButton button2 = new JButton("Cancel");
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button2.setBounds(150, 80, 100, 18);
			Container container = getContentPane();
			container.setLayout(null);
			container.add(label1);
			container.add(label2);
			container.add(textField1);
			container.add(textField2);
			container.add(button1);
			container.add(button2);
			setBounds(0, 0, 300, 150);
			setAlwaysOnTop(true);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
	}

	class Register extends JFrame {
		public Register() {
			setTitle("Register");
			JLabel label1 = new JLabel("UserName");
			label1.setBounds(10, 10, 200, 18);
			JLabel label2 = new JLabel("Password");
			label2.setBounds(10, 50, 200, 18);
			JTextField textField1 = new JTextField();
			textField1.setBounds(90, 10, 150, 18);
			JTextField textField2 = new JTextField();
			textField2.setBounds(90, 50, 150, 18);
			JButton button1 = new JButton("Confirm");
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserData userData = new UserData();
					User user = new User(textField1.getText(), textField2.getText());
					if (userData.register(user))
						JOptionPane.showMessageDialog(button1, "Sucsuss");
					else
						JOptionPane.showMessageDialog(button1, "Fail");
					dispose();
				}
			});
			button1.setBounds(40, 80, 100, 18);
			JButton button2 = new JButton("Cancel");
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button2.setBounds(150, 80, 100, 18);
			Container container = getContentPane();
			container.setLayout(null);
			container.add(label1);
			container.add(label2);
			container.add(textField1);
			container.add(textField2);
			container.add(button1);
			container.add(button2);
			setBounds(0, 0, 300, 150);
			setAlwaysOnTop(true);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
	}
}
