import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {
	Grid grid;

	public Game() {
		setTitle("Run Like Hell");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600); ////////////the location and the size of the program
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		getContentPane().add(new Paint());
		panel.setLayout(new GridLayout(10, 10, 10, 10));/////////////the distance between buttons
		JButton start = new JButton("Start");  ///////////////////all button starts here
		JButton pause = new JButton("Pause");
		JButton login = new JButton("LogIn");
		JButton register = new JButton("Register");
		login.addActionListener(new MyActionListener());
		register.addActionListener(new MyActionListener());
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
class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String label = ((JButton)e.getSource()).getLabel();
		if("LogIn".equals(label)) {
			new Login();
		}
		if(label.equals("Register")) {
			new Register();
		}
	}
}
class Login extends JFrame {
	public Login() {
		setTitle("Login");
		JLabel label1 = new JLabel("UserName");
		label1.setBounds(10,10,200,18);
		JLabel label2 = new JLabel("Password");
		label2.setBounds(10,50,200,18);
		JTextField textField1 = new JTextField();
		textField1.setBounds(90,10,150,18);
		JTextField textField2 = new JTextField();
		textField2.setBounds(90,50,150,18);
		JButton button1 = new JButton("Confirm");
		button1.setBounds(40,80,100,18);
		JButton button2 = new JButton("Cancel");
		button2.setBounds(150,80,100,18);
		Container container =getContentPane();
		container.setLayout(null);
		container.add(label1);
		container.add(label2);
		container.add(textField1);
		container.add(textField2);
		container.add(button1);
		container.add(button2);
		setBounds(0,0,300,150);
		setAlwaysOnTop(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
class Register extends JFrame {
	public Register() {
		setTitle("Login");
		JLabel label1 = new JLabel("UserName");
		label1.setBounds(10,10,200,18);
		JLabel label2 = new JLabel("Password");
		label2.setBounds(10,50,200,18);
		JTextField textField1 = new JTextField();
		textField1.setBounds(90,10,150,18);
		JTextField textField2 = new JTextField();
		textField2.setBounds(90,50,150,18);
		JButton button1 = new JButton("Confirm");
		button1.setBounds(40,80,100,18);
		JButton button2 = new JButton("Cancel");
		button2.setBounds(150,80,100,18);
		Container container =getContentPane();
		container.setLayout(null);
		container.add(label1);
		container.add(label2);
		container.add(textField1);
		container.add(textField2);
		container.add(button1);
		container.add(button2);
		setBounds(0,0,300,150);
		setAlwaysOnTop(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
