
public class User {
	String userName;
	String password;
	int score;
	boolean isLogin;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.score = 0;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public int getScore() {
		return score;
	}
}
