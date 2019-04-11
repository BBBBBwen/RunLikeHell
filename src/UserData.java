import java.io.*;
import java.util.ArrayList;

public class UserData {
	ArrayList<User> users = new ArrayList<User>();
	File file = new File("data.txt");

	public String getName(int index) {
		return users.get(index).getUserName();
	}

	public boolean isRegister(User user) {
		try {
			InputStreamReader read;
			try {
				read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineT = null;
				while((lineT = bufferedReader.readLine()) != null) {
					String[] str = lineT.split(" ");
					User userReg = new User(str[0],str[1]);
					users.add(userReg);
				}
				if(!user.getUserName().equals(user.getUserName())){
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write(user.getUserName()+" "+user.getPassword()+"\n");
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean isLogin(String userName, String password) {
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineT = null;
			while((lineT = bufferedReader.readLine()) != null) {
				String[] str = lineT.split(" ");
				User user = new User(str[0],str[1]);
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
