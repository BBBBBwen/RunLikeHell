import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class UserDataTest {

	@Test
	void testReg() throws IOException {
		UserData users = new UserData();
		User user = new User("abc123", "123456");
		User user1 = new User("abc123", "123456");
		users.register(user);
		assertTrue(users.register(user1));
	}

	@Test
	void testLog() {
		User user = new User("abc123", "123456");
		UserData users = new UserData();
		if (users.register(user))
			assertTrue(users.login("abc123", "123456"));
	}
	
	@Test
	void logWithoutReg() {
		UserData users = new UserData();
		assertFalse(users.login("abc567", "123456"));
	}
	
	@Test
	void testRank() {
		UserData users = new UserData();
		System.out.print(users.getList());
	}
}
