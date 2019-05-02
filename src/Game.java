import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {
	private int timeAllowed = 100;
	private int difficulty;
	private JLabel time;
	private Grid grid;
	private Paint paint;
	private Player player;
	private Monster monster;
	private User user;
	private UserData userData;
	public Game() {
		this.setDifficulty();
		grid = new Grid(difficulty);
		player = new Player(0, 0, 0);
		monster = new Monster(5, 5, 1);
		paint = new Paint(player,monster,grid);
		setTitle("Run Like Hell");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)(640 * (1 + difficulty * 0.25)), (int)(480 * (1 + difficulty * 0.25))); //////////// the location and the size of the program
		setResizable(false);
		JPanel controlPane = new JPanel();
		controlPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		controlPane.setLayout(new BorderLayout(5, 5));
		controlPane.setLayout(new GridLayout(10, 10, 10, 10));///////////// the distance between buttons
		JButton start = new JButton("Start"); /////////////////// all button starts here
		JButton pause = new JButton("Pause");
		JButton login = new JButton("LogIn");
		JButton register = new JButton("Register");
		JButton rank = new JButton("Rank");
		JButton setting = new JButton("Setting");
		start.addActionListener(new MyActionListener());
		pause.addActionListener(new MyActionListener());
		login.addActionListener(new MyActionListener());
		register.addActionListener(new MyActionListener());
		rank.addActionListener(new MyActionListener());
		time = new JLabel("Time Unit: " + timeAllowed);
		controlPane.add(start);
		controlPane.add(pause);
		controlPane.add(login);
		controlPane.add(register);
		controlPane.add(rank);
		controlPane.add(setting);
		controlPane.add(time);
		start.addKeyListener(player);
		add(controlPane, BorderLayout.EAST);
		this.add(paint, BorderLayout.CENTER);
	}
	
	public void setDifficulty() {
		String diff = JOptionPane.showInputDialog(null, "set Diificuty(easy,normal,hard)");
		if (diff.equals("easy"))
			this.difficulty = 0;
		else if (diff.equals("normal"))
			this.difficulty = 1;
		else if (diff.equals("hard"))
			this.difficulty = 2;
	}
	
	public static void main(String args[]) throws Exception {
		Game frame = new Game();
		frame.setVisible(true);
		frame.play();
	}

	public void setTime(int timeAllowed) {
		this.timeAllowed = timeAllowed;
	}
	public int getTime() {
		return timeAllowed;
	}
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		while(!player.isReady())
			delay(1000);
		int time = 0;
		String message;
		while (time < timeAllowed) {
			player.action();
			time++;
			this.time.setText("Time Unit: " + (timeAllowed - time));
			delay(1000);
			paint.repaint();
		}
		user.setScore(timeAllowed - time);
		message = (time < timeAllowed) ? "player Lost" : "player Win";
		this.time.setText(message);
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