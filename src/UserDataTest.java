import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDataTest {

	@Test
	void testReg() {
		UserData users = new UserData();
		User user = new User("abc123", "123456");
		User user1 = new User("abc123", "123456");
		assertFalse(users.isRegister(user1));
	}

	@Test
	void testLog() {
		User user = new User("abc123", "123456");
		UserData users = new UserData();
		if (users.isRegister(user))
			assertTrue(users.isLogin("abc123", "123456"));
	}

}
