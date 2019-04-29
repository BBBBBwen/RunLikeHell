import java.io.*;
import java.util.ArrayList;

public class UserData {
	ArrayList<User> users = new ArrayList<User>();
	File file = new File("data.txt");

	public String getName(int index) {
		return users.get(index).getUserName();
	}
	
	public String getList() {
		String msg = "";
		try {
			InputStreamReader read;
			read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineT = null;
			while ((lineT = bufferedReader.readLine()) != null) {
				String[] str = lineT.split(" ");
				msg = str[0] + " " + str[2] + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public boolean register(User user) {
		try {
			InputStreamReader read;
			read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineT = null;
			while ((lineT = bufferedReader.readLine()) != null) {
				String[] str = lineT.split(" ");
				User userReg = new User(str[0], str[1]);
				userReg.setScore(Integer.parseInt(str[2]));
				users.add(userReg);
			}
			for (User u : users)
			if (!u.getUserName().equals(user.getUserName())) {
				return false;
			}
			FileWriter fileWriter = new FileWriter(file);
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
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineT = null;
			while ((lineT = bufferedReader.readLine()) != null) {
				String[] str = lineT.split(" ");
				User user = new User(str[0], str[1]);
				users.add(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean flag = false;
		for (User user : users) {
			if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
