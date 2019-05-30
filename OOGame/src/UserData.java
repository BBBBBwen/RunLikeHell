
import java.io.*;
import java.util.ArrayList;

public class UserData {
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser;
	private File file = new File("data.save");
	private boolean isLogin = false;

	public UserData() {
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineT = null;
			while ((lineT = bufferedReader.readLine()) != null) {
				String[] str = lineT.split(" ");
				User userReg = new User(str[0], str[1]);
				userReg.setScore(Integer.parseInt(str[2]));
				users.add(userReg);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveScore(int score) {
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			for (User user : users) {
				if (user.getUserName() == currentUser.getUserName()) {
					if (user.getScore() < score)
						user.setScore(score);
				}
				bufferWriter.write(user.getUserName() + " " + user.getPassword() + " " + user.getScore() + "\n");
			}
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName(int index) {
		return users.get(index).getUserName();
	}

	public User[] getList() {
		ArrayList<User> usersTemp = users;
		for (int i = 0; i < usersTemp.size() - 1; ++i) {
			for (int j = i; j < usersTemp.size() - 1 - i; ++j) {
				if (usersTemp.get(j).getScore() < usersTemp.get(j + 1).getScore()) {
					User temp = usersTemp.get(j);
					usersTemp.set(j, usersTemp.get(j + 1));
					usersTemp.set(j + 1, temp);
				}
			}
		}
		int rankSize = usersTemp.size() <= 10 ? usersTemp.size() : 10;
		User[] userList = new User[rankSize];
		for (int i = 0; i < rankSize; i++)
			userList[i] = usersTemp.get(i);
		return userList;
	}

	public boolean register(User user) {
		for (User u : users)
			if (u.getUserName().equals(user.getUserName())) {
				return false;
			}
		try {
			users.add(user);
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(user.getUserName() + " " + user.getPassword() + " " + user.getScore() + "\n");
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean login(String userName, String password) {
		boolean flag = false;
		for (User user : users) {
			if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
				flag = true;
				currentUser = user;
				isLogin = true;
				break;
			}
		}
		return flag;
	}

	public boolean isLogin() {
		return isLogin;
	}
}
