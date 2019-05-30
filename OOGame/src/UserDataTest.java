import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class UserDataTest {

	@Test
	void testReg() throws IOException {
		UserData users = new UserData();
		User user = new User("user1", "123456");
		User user1 = new User("user1", "123456");
		assertFalse(users.register(user));
		assertFalse(users.register(user1));
	}

	@Test
	void testLog() {
		UserData users = new UserData();
		assertTrue(users.login("user1", "123456"));
	}

	@Test
	void logWithoutReg() {
		UserData users = new UserData();
		assertFalse(users.login("abc567", "123456"));
	}

	@Test
	void testRank() {
		UserData users = new UserData();
		assertTrue(users.getList()[0].getScore() == 109);
	}

}
